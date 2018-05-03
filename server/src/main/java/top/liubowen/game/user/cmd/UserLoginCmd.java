package top.liubowen.game.user.cmd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.liubowen.UserProtocol.Client;
import top.liubowen.UserProtocol.Server;
import top.liubowen.annotation.Cmd;
import top.liubowen.common.cmd.ICmd;
import top.liubowen.common.session.Session;
import top.liubowen.proto.CoreProto.LongMsg;
import top.liubowen.proto.CoreProto.Message;
import top.liubowen.proto.CoreProto.StringMsg;

/**
 * @author liubowen
 * @date 2018/5/3 20:37
 * @description
 */
@Cmd(Client.USER_LOGIN_REQ)
@Component
@Slf4j
public class UserLoginCmd implements ICmd {

    @Override
    public void execute(Session session, Message message) throws Exception {
        long userId = LongMsg.parseFrom(message.getBody()).getValue();
        log.info("user login userId = {}", userId);

        Message ret = Message.newBuilder().setCmd(Server.USER_LOGIN_RET).setBody(StringMsg.newBuilder().setValue("周杰伦").build().toByteString()).build();
        session.send(ret);
    }
}
