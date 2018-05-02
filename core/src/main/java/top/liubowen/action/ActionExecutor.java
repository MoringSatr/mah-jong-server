package top.liubowen.action;

/**
 * 
 * @author luzj
 *
 */
public interface ActionExecutor {

    ActionQueue defaultQueue();

    void delayCheck(DelayAction action);

    void execute(Runnable action);

    void shutdown();

}
