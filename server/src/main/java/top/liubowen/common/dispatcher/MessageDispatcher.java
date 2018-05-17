package top.liubowen.common.dispatcher;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.liubowen.common.cmd.CmdContext;
import top.liubowen.common.session.ISession;
import top.liubowen.common.session.PlayerSession;
import top.liubowen.common.session.PlayerSessionContext;
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
    private PlayerSessionContext sessionContext;
    @Autowired
    private CmdContext cmdContext;

    @OnConnect
    public void onConnect(SocketIOClient client) {
        ISession session = PlayerSession.get(client);
        // sessionContext.add(session);
        log.debug("【一个客户端加入连接】sessionId : {}", session.sessionId());
    }

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        ISession session = PlayerSession.get(client);
        sessionContext.remove(session.sessionId());
        log.debug("【一个客户端断开连接】sessionId : {}", session.sessionId());
    }

    @OnEvent(value = "message")
    public void onMessage(SocketIOClient client, AckRequest request, byte[] data) {
        ISession session = PlayerSession.get(client);
        try {
            Message message = Message.parseFrom(data);
            if (message == null) {
                log.debug("【一个客户端发送消息，消息为空】sessionId : {}", session.sessionId());
                return;
            }
            cmdContext.execute(session, message);
        } catch (Exception e) {
            log.error("【一个客户端发送消息，消息解析失败】sessionId : {}", session.sessionId(), e);
        }
        log.debug("【一个客户端发送消息】sessionId : {}", session.sessionId());
    }
}
