package top.liubowen.game.user.cmd;

import lombok.extern.slf4j.Slf4j;
import top.liubowen.UserProtocol.Server;
import top.liubowen.common.cmd.PlayerQueuedCommand;
import top.liubowen.game.player.domain.GamePlayer;
import top.liubowen.proto.CoreProto.LongMsg;
import top.liubowen.proto.CoreProto.Message;
import top.liubowen.proto.CoreProto.StringMsg;

/**
 * @author liubowen
 * @date 2018/5/3 20:37
 * @description
 */
@Slf4j
public class UserLoginCmd extends PlayerQueuedCommand<LongMsg> {

    @Override
    public void execute(GamePlayer gamePlayer, LongMsg message) throws Exception {
        long userId = message.getValue();
        log.info("user login userId = {}", userId);

        Message ret = Message.newBuilder().setCmd(Server.USER_LOGIN_RET).setBody(StringMsg.newBuilder().setValue("周杰伦").build().toByteString()).build();
        gamePlayer.send(ret);
    }

}
