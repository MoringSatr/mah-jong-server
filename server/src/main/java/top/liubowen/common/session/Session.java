package top.liubowen.common.session;

import com.corundumstudio.socketio.SocketIOClient;
import io.netty.util.AttributeKey;
import lombok.Getter;
import lombok.ToString;
import top.liubowen.proto.CoreProto.Message;

/**
 * @author liubowen
 * @date 2017/11/10 1:55
 * @description 玩家连接信息
 */
@ToString
public class Session {

    private static final AttributeKey<Session> SESSION_KEY = AttributeKey.valueOf("SESSION");

    private static final String SEND_EVENT = "message";

    /**
     * 玩家客户端连接
     */
    @Getter
    private SocketIOClient client;

    /**
     * 玩家id
     */
    private long userId;

    private Session() {
    }

    public static Session get(SocketIOClient client) {
        Session session = client.get(SESSION_KEY.name());
        if (session == null) {
            session = new Session();
            session.bind(client);
        }
        return session;
    }

    /**
     * 玩家登陆，绑定玩家id
     */
    public void login(long userId) {
        this.userId = userId;
    }

    /**
     * 获取玩家sessionId
     */
    public String sessionId() {
        if (client == null) {
            return "";
        }
        return client.getSessionId().toString();
    }

    /**
     * 玩家id
     */
    public long userId() {
        return this.userId;
    }

    /**
     * 玩家是否登陆
     */
    public boolean isLogin() {
        return this.userId != 0;
    }

    /**
     * 发送消息
     */
    public void send(Message message) {
        this.client.sendEvent(SEND_EVENT, message.toByteArray());
    }

    /**
     * 发送消息并且关闭连接
     */
    public void sendAndClose(Message message) {
        this.send(message);
        this.client.disconnect();
    }

    /**
     * 绑定玩家session
     */
    private void bind(SocketIOClient client) {
        this.client = client;
        client.set(SESSION_KEY.name(), this);
    }

    public void disconnect() {
        this.client.disconnect();
    }

}
