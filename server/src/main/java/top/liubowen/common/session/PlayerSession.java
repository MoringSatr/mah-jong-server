package top.liubowen.common.session;

import com.corundumstudio.socketio.SocketIOClient;
import io.netty.util.AttributeKey;
import lombok.Getter;
import lombok.ToString;
import top.liubowen.proto.CoreProto.Message;

/**
 * @author liubowen
 * @date 2017/11/10 1:55
 * @description 玩家Session
 */
@ToString
public class PlayerSession implements ISession {

    private static final AttributeKey<ISession> SESSION_KEY = AttributeKey.valueOf("SESSION");

    private static final String SEND_EVENT = "message";

    /**
     * 玩家客户端连接
     */
    @Getter
    private SocketIOClient client;

    /** 玩家id */
    private long playerId;

    private PlayerSession() {
    }

    public static ISession get(SocketIOClient client) {
        PlayerSession playerSession = client.get(SESSION_KEY.name());
        if (playerSession == null) {
            playerSession = new PlayerSession();
            playerSession.bind(client);
        }
        return playerSession;
    }

    /** 绑定玩家session */
    private void bind(SocketIOClient client) {
        this.client = client;
        client.set(SESSION_KEY.name(), this);
    }

    @Override
    public long id() {
        return playerId;
    }

    @Override
    public String sessionId() {
        if (client == null) {
            return "";
        }
        return client.getSessionId().toString();
    }

    @Override
    public ISession bind(long id) {
        playerId = id;
        return this;
    }

    @Override
    public void send(Message message) {
        this.client.sendEvent(SEND_EVENT, message.toByteArray());
    }

    @Override
    public void close() {
        this.client.disconnect();
    }
}
