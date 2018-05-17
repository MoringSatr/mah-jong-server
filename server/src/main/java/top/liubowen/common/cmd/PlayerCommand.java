package top.liubowen.common.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.protobuf.MessageLite;

import top.liubowen.common.player.GamePlayerLoader;
import top.liubowen.common.session.ISession;
import top.liubowen.game.player.domain.GamePlayer;

/**
 * @author liubowen
 * @date 2018/5/4 13:56
 * @description 玩家命令处理
 */
@Component
public abstract class PlayerCommand<T extends MessageLite> implements Command<T> {

    @Autowired
    private GamePlayerLoader gamePlayerLoader;

    @Override
    public void execute(ISession session, T message) throws Exception {
        if (!gamePlayerLoader.exists(session.id())) {
            return;
        }
        GamePlayer player = gamePlayerLoader.getPlayer(session.id());
        exec(player, message);
    }

    public abstract void exec(GamePlayer gamePlayer, T message) throws Exception;

}
