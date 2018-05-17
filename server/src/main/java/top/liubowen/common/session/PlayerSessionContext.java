package top.liubowen.common.session;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.liubowen.proto.CoreProto.Message;

import java.util.Map;

/**
 * @author liubowen
 * @date 2017/11/10 1:55
 * @description 玩家session管理
 */
@Slf4j
@Component("playerSessionContext")
public class PlayerSessionContext {

    /** 玩家session集合，< playerId, session > */
    private Map<Long, ISession> sessions = Maps.newConcurrentMap();

    /** 添加session */
    public void add(ISession session) {
        this.sessions.putIfAbsent(session.id(), session);
    }

    /** 获取session */
    public ISession get(long playerId) {
        return this.sessions.get(playerId);
    }

    /** 移除session */
    public void remove(long playerId) {
        this.sessions.remove(playerId);
    }

    /** 当前连接数 */
    public int size() {
        return sessions.size();
    }

    /** 向某个玩家发送消息 */
    public void send(long playerId, Message message) {
        ISession session = get(playerId);
        if (session == null) {
            log.debug("session is null , playerId : {}", playerId);
            return;
        }
        session.send(message);
    }

    /** 向所有人发送消息 */
    public void send(Message message) {
        sessions.values().forEach(session -> session.send(message));
    }

}
