package top.liubowen.core;

import top.liubowen.proto.CoreProto.Message;

/**
 * @author liubowen
 * @date 2018/5/4 14:29
 * @description 消息发送器接口
 */
public interface IMessageSender {

    void send(Message message);

}
