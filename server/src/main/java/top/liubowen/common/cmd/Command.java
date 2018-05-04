package top.liubowen.common.cmd;

import top.liubowen.common.session.Session;

/**
 * @author liubowen
 * @date 2017/11/7 16:21
 * @description
 */
public interface Command<T> {

    void execute(Session session, T message) throws Exception;
}
