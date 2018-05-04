package top.liubowen.game.player.domain;

import top.liubowen.action.ActionExecutor;
import top.liubowen.action.ActionQueue;
import top.liubowen.common.Sender;
import top.liubowen.common.session.Session;
import top.liubowen.proto.CoreProto.Message;
import top.liubowen.tools.ThreadPoolActionExecutor;

/**
 * @author liubowen
 * @date 2018/5/4 14:13
 * @description
 */
public class GamePlayer implements Sender {

    private ActionExecutor actionExecutor = new ThreadPoolActionExecutor(2, 2, "player");

    private Session session;
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

    public GamePlayer(Session session, long playerId) {
        this.session = session;
        this.playerId = playerId;
    }
}
