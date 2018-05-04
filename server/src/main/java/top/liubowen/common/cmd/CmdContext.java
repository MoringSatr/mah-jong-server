package top.liubowen.common.cmd;

import com.google.common.collect.Maps;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.liubowen.annotation.Cmd;
import top.liubowen.common.invoker.DecodeInvoker;
import top.liubowen.common.scanner.MessageClassContext;
import top.liubowen.common.session.Session;
import top.liubowen.proto.CoreProto.Message;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author liubowen
 * @date 2017/11/1 20:26
 * @description cmd消息处理器管理类
 */
@Component
@Slf4j
public class CmdContext {

    /**
     * 命令消息处理器map
     */
    private Map<Integer, Command> commandMap = Maps.newHashMap();

    /**
     * 命令消息解码器map
     */
    private Map<Integer, DecodeInvoker> decodeInvokerMap = Maps.newHashMap();

    @Autowired
    private MessageClassContext messageClassContext;

    public void add(Command command) {
        Class<?> clazz = command.getClass();
        Cmd cmd = clazz.getAnnotation(Cmd.class);
        int cmdCode = cmd.value();
        try {
            // Type[] interfacesTypes = clazz.getGenericInterfaces();
            // Type rawType = interfacesTypes[0];
            // Class rawClazz = (Class) ((ParameterizedType) rawType).getActualTypeArguments()[0];
            Class rawClazz = this.messageClassContext.get(cmdCode);
            if (rawClazz != null && rawClazz != Class.class) {
                boolean isFather = MessageLite.class.isAssignableFrom(rawClazz);
                if (isFather) {
                    Method method = rawClazz.getMethod("parseFrom", new Class[] { ByteString.class });
                    DecodeInvoker decodeInvoker = new DecodeInvoker(cmdCode, rawClazz, method);
                    this.decodeInvokerMap.put(cmdCode, decodeInvoker);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.commandMap.put(cmdCode, command);
    }

    private Command get(int cmd) {
        if (this.commandMap.containsKey(cmd)) {
            return this.commandMap.get(cmd);
        }
        return null;
    }

    private DecodeInvoker getDecodeInvoker(int cmd) {
        if (this.decodeInvokerMap.containsKey(cmd)) {
            return this.decodeInvokerMap.get(cmd);
        }
        return null;
    }

    public void execute(Session session, Message message) throws Exception {
        int cmd = message.getCmd();
        ByteString bytes = message.getBody();
        Command command = this.get(cmd);
        DecodeInvoker decodeInvoker = this.getDecodeInvoker(cmd);
        if (decodeInvoker == null) {
            command.execute(session, null);
            return;
        }
        decodeInvoker = this.getDecodeInvoker(cmd);
        MessageLite messageLite = decodeInvoker.invoke(MessageLite.class, bytes);
        command.execute(session, messageLite);
    }

}
