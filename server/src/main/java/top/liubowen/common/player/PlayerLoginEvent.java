package top.liubowen.common.player;

import lombok.Getter;
import top.liubowen.event.Event;

/**
 * @author liubowen
 * @date 2018/5/4 14:37
 * @description
 */
@Getter
public class PlayerLoginEvent extends Event {

    private long playerId;

    public PlayerLoginEvent(long playerId) {
        super(10001);
        this.playerId = playerId;
    }
}
