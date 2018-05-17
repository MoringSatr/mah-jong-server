package top.liubowen.common.player;

import com.google.protobuf.MessageLite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.liubowen.UserProtocol.Client;
import top.liubowen.UserProtocol.Server;
import top.liubowen.annotation.Cmd;
import top.liubowen.common.cmd.Command;
import top.liubowen.common.session.ISession;
import top.liubowen.event.Event;
import top.liubowen.event.EventListener;
import top.liubowen.event.EventNotifier;
import top.liubowen.game.player.domain.GamePlayer;
import top.liubowen.proto.CoreProto.LongMsg;
import top.liubowen.proto.CoreProto.Message;
import top.liubowen.proto.CoreProto.StringMsg;

/**
 * @author liubowen
 * @date 2018/5/4 14:30
 * @description
 */
@Cmd(Client.USER_LOGIN_REQ)
@Component
public class PlayerLoginCmd implements Command<LongMsg> {

    @Autowired
    private GamePlayerLoader gamePlayerLoader;

    @Override
    public void execute(ISession session, LongMsg message) throws Exception {
        long playerId = message.getValue();
        gamePlayerLoader.login(session, playerId);
        session.bind(playerId);

        EventNotifier.getInstance().registListener(new EventListener(10001) {
            @Override
            public void onEvent(Event event) {
                PlayerLoginEvent playerLoginEvent = event.cast();
                GamePlayer player = gamePlayerLoader.getPlayer(playerLoginEvent.getPlayerId());
                MessageLite retMsg = StringMsg.newBuilder().setValue("周杰伦登陆").build();
                Message message1 = Message.newBuilder().setCmd(Server.USER_LOGIN_RET).setBody(retMsg.toByteString()).build();
                player.send(message1);
            }
        });

        // 发送登陆成功事件
        EventNotifier.getInstance().notifyEvent(new PlayerLoginEvent(playerId));

    }

}
