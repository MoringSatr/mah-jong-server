package top.liubowen.core.player;

import top.liubowen.action.ActionQueue;
import top.liubowen.common.annotation.Inject;
import top.liubowen.common.annotation.Prototype;
import top.liubowen.common.session.PlayerSessionContext;
import top.liubowen.core.IEventNotifier;
import top.liubowen.core.IMessageSender;
import top.liubowen.event.Event;
import top.liubowen.event.EventNotifier;
import top.liubowen.proto.CoreProto.Message;
import top.liubowen.proto.PlayerProto.PlayerState;

/**
 * @author liubowen
 * @date 2018/5/11 17:00
 * @description
 */
@Prototype
public abstract class CorePlayer extends Player implements IMessageSender, IEventNotifier {

    @Inject
    private PlayerSessionContext sessionContext;

    private transient PlayerState playerState;
    private transient EventNotifier eventNotifier;

    public CorePlayer(ActionQueue queue, long playerId) {
        super(queue, playerId);
        playerState = PlayerState.OFFLINE;
        eventNotifier = new EventNotifier();
    }

    @Override
    public void notify(Event event) {
        eventNotifier.notify(event);
    }

    @Override
    public void send(Message message) {
        if (!isOnline()) {
            return;
        }
        sessionContext.send(playerId, message);
    }

    @Override
    public boolean isOnline() {
        return playerState == PlayerState.ONLINE;
    }

    public void login() {
        playerState = PlayerState.ONLINE;
    }

    public void logout() {
        playerState = PlayerState.OFFLINE;
    }

}
