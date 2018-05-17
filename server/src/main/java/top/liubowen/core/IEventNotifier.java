package top.liubowen.core;

import top.liubowen.event.Event;

/**
 * @author liubowen
 * @date 2018/5/11 16:41
 * @description 消息发送器接口
 */
public interface IEventNotifier {

    void notify(Event event);

}
