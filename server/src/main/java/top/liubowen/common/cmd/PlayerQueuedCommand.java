package top.liubowen.common.cmd;

import com.google.protobuf.MessageLite;
import org.springframework.stereotype.Component;
import top.liubowen.action.RunnableAction;
import top.liubowen.game.player.domain.GamePlayer;

/**
 * @author liubowen
 * @date 2018/5/4 13:56
 * @description 玩家队列命令处理
 */
@Component
public abstract class PlayerQueuedCommand<T extends MessageLite> extends PlayerCommand<T> {

    @Override
    public void exec(GamePlayer gamePlayer, T message) throws Exception {
        RunnableAction.of(gamePlayer.queue(), () -> {
            try {
                execute(gamePlayer, message);
            } catch (Exception e) {
                // TODO handle player req exception
            }
        });
    }

    public abstract void execute(GamePlayer gamePlayer, T message) throws Exception;

}
