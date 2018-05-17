package top.liubowen.common.player;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import top.liubowen.common.session.ISession;
import top.liubowen.common.session.PlayerSession;
import top.liubowen.game.player.domain.GamePlayer;

import java.util.Map;

/**
 * @author liubowen
 * @date 2018/5/4 14:11
 * @description
 */
@Component
public class GamePlayerLoader {

    private Map<Long, GamePlayer> players = Maps.newConcurrentMap();

    public boolean exists(long playerId) {
        return players.containsKey(playerId);
    }

    public GamePlayer getPlayer(long playerId) {
        return players.get(playerId);
    }

    public GamePlayer login(ISession session, long playerId) {
        // TODO 数据库或内纯中加载player
        GamePlayer gamePlayer = new GamePlayer(session, playerId);
        players.put(gamePlayer.playerId(), gamePlayer);
        return gamePlayer;
    }

}
