package top.liubowen.common.session;

import com.corundumstudio.socketio.SocketIOClient;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import top.liubowen.proto.CoreProto.Message;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

/**
 * @author liubowen
 * @date 2017/11/10 1:55
 * @description 玩家session管理
 */
@Component
public class SessionContext {

    /** 玩家session集合，< sessionId, session > */
    private ConcurrentMap<String, Session> sessionConcurrentMap = Maps.newConcurrentMap();

    /** 添加session */
    public void add(Session session) {
        this.sessionConcurrentMap.putIfAbsent(session.sessionId(), session);
    }

    /** 获取session */
    public Session get(String sessionId) {
        return this.sessionConcurrentMap.get(sessionId);
    }

    /** 移除session */
    public void remove(String sessionId) {
        this.sessionConcurrentMap.remove(sessionId);
    }

    /** 获取所有session */
    public List<Session> all() {
        return Lists.newArrayList(this.sessionConcurrentMap.values());
    }

    /** 向所有session发送信息 */
    public void sendToAll(Message message) {
        this.all().forEach(session -> {
            session.send(message);
        });
    }

    /** 向某个session发送信息 */
    public void sendToSession(String sessionId, Message message) {
        if (this.sessionConcurrentMap.containsKey(sessionId)) {
            this.get(sessionId).send(message);
        }
    }

    /** 获取session */
    public Session get(SocketIOClient client) {
        String sessionId = client.getSessionId().toString();
        return this.get(sessionId);
    }

}
