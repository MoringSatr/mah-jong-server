package top.liubowen.common.dispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.corundumstudio.socketio.SocketIOClient;
import com.google.protobuf.InvalidProtocolBufferException;

import lombok.extern.slf4j.Slf4j;
import top.liubowen.common.cmd.CmdContext;
import top.liubowen.common.cmd.ICmd;
import top.liubowen.common.session.Session;
import top.liubowen.common.session.SessionContext;
import top.liubowen.proto.CoreProto.Message;

/**
 * @author liubowen
 * @date 2017/11/10 2:45
 * @description 玩家socketio消息分发器
 */
@Component
@Slf4j
public class MessageDispatcher {

    @Autowired
    private SessionContext sessionContext;
    @Autowired
    private CmdContext cmdContext;

    public void onConnect(SocketIOClient client) {
        Session session = Session.get(client);
        sessionContext.add(session);
        log.info("【一个客户端加入连接】sessionId : {}", session.sessionId());
    }

    public void onDisconnect(SocketIOClient client) {
        Session session = Session.get(client);
        sessionContext.remove(session.sessionId());
        log.info("【一个客户端断开连接】sessionId : {}", session.sessionId());
    }

    public void onMessage(SocketIOClient client, byte[] data) {
        Session session = Session.get(client);
        try {
            Message message = Message.parseFrom(data);
            if (message == null) {
                log.info("【一个客户端发送消息，消息为空】sessionId : {}", session.sessionId());
                return;
            }
            ICmd cmd = cmdContext.getCmd(message.getCmd());
            if (cmd == null) {
                log.info("【一个客户端发送消息，未找到cmd】sessionId : {}， cmd : {}", session.sessionId(), message.getCmd());
                return;
            }
            cmd.execute(session, message);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("【一个客户端发送消息，消息解析失败】sessionId : {}", session.sessionId());
        }
        log.info("【一个客户端发送消息】sessionId : {}", session.sessionId());
    }
}
