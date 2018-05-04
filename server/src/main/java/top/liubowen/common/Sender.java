package top.liubowen.common;

import top.liubowen.proto.CoreProto.Message;

/**
 * @author liubowen
 * @date 2018/5/4 14:29
 * @description 发送消息
 */
public interface Sender {
    void send(Message message);
}
