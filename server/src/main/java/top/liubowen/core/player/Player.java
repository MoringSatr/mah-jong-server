package top.liubowen.core.player;

import top.liubowen.action.ActionQueue;
import top.liubowen.core.Loadable;
import top.liubowen.core.Saveable;

/**
 * @author liubowen
 * @date 2018/5/11 16:44
 * @description 玩家
 */
public abstract class Player implements Saveable, Loadable {

    /** 玩家队列 */
    protected ActionQueue queue;
    /** 玩家id */
    protected long playerId;

    public Player(ActionQueue queue, long playerId) {
        this.queue = queue;
        this.playerId = playerId;
    }

    public ActionQueue queue() {
        return this.queue;
    }

    public long playerId() {
        return playerId;
    }

    public abstract boolean isOnline();

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }
}
