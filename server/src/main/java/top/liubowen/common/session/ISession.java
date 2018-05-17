package top.liubowen.common.session;

import top.liubowen.proto.CoreProto.Message;

/**
 * @author liubowen
 * @date 2018/5/11 17:01
 * @description session接口
 */
public interface ISession {

    /** id */
    long id();

    /** session id */
    String sessionId();

    /** 绑定id */
    ISession bind(long id);

    /** 发送消息 */
    void send(Message message);

    /** 关闭session */
    void close();

    /** 发送并且关闭关闭session */
    default void sendAndClose(Message message) {
        send(message);
        close();
    }

}
