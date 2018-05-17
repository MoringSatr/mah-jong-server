package top.liubowen.game.player.domain;

import top.liubowen.action.ActionExecutor;
import top.liubowen.action.ActionQueue;
import top.liubowen.common.session.ISession;
import top.liubowen.core.IMessageSender;
import top.liubowen.proto.CoreProto.Message;
import top.liubowen.tools.ThreadPoolActionExecutor;

/**
 * @author liubowen
 * @date 2018/5/4 14:13
 * @description
 */
public class GamePlayer implements IMessageSender {

    private ActionExecutor actionExecutor = new ThreadPoolActionExecutor(2, 2, "player");

    private ISession session;
    private long playerId;

    public long playerId() {
        return playerId;
    }

    public ActionQueue queue() {
        return new ActionQueue(actionExecutor);
    }

    @Override
    public void send(Message message) {
        session.send(message);
    }

    public GamePlayer(ISession session, long playerId) {
        this.session = session;
        this.playerId = playerId;
    }
}
