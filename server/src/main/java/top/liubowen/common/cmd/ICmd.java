package top.liubowen.common.cmd;

import top.liubowen.common.session.Session;
import top.liubowen.proto.CoreProto.Message;

/**
 * @author liubowen
 * @date 2017/11/1 20:03
 * @description
 */
public interface ICmd {

    void execute(Session session, Message message) throws Exception;

}
