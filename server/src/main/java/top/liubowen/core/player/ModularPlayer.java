package top.liubowen.core.player;

import top.liubowen.action.ActionQueue;
import top.liubowen.core.Destroyable;

/**
 * @author liubowen
 * @date 2018/5/11 16:47
 * @description 模块玩家信息
 */
public abstract class ModularPlayer extends Player implements Destroyable {

    public ModularPlayer(ActionQueue queue, long playerId) {
        super(queue, playerId);
    }

    @Override
    public void destroy() {

    }

    @Override
    public boolean isOnline() {
        return false;
    }

}
