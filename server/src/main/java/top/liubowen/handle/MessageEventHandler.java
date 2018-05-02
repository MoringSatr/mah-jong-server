package top.liubowen.handle;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.sun.nio.sctp.MessageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 刘博文 on 2017/10/24.
 */
@Component
@Slf4j
public class MessageEventHandler {

    @Autowired
    private SocketIOServer server;

    // 添加connect事件，当客户端发起连接时调用，本文中将clientid与sessionid存入数据库
    // 方便后面发送消息时查找到对应的目标client,
    @OnConnect
    public void onConnect(SocketIOClient client) {
        log.info("onConnect");
    }

    // 添加@OnDisconnect事件，客户端断开连接时调用，刷新客户端信息
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
    }

    // 消息接收入口，当接收到消息后，查找发送目标客户端，并且向该客户端发送消息，且给自己发送消息
    @OnEvent(value = "message")
    public void onEvent(SocketIOClient client, AckRequest request, MessageInfo data) {

    }
}