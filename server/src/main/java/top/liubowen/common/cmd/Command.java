package top.liubowen.common.cmd;

import top.liubowen.common.session.ISession;

/**
 * @author liubowen
 * @date 2017/11/7 16:21
 * @description
 */
public interface Command<T> {

    void execute(ISession playerSession, T message) throws Exception;
}
