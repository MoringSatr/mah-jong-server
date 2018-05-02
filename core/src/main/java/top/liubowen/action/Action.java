package top.liubowen.action;

import lombok.extern.slf4j.Slf4j;
import top.liubowen.tools.Monitor;
import top.liubowen.tools.Sequential;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public abstract class Action implements Runnable, Sequential {

    protected ActionQueue queue;
    protected long createTime;

    public Action(ActionQueue queue) {
        this.queue = queue;
        this.createTime = System.currentTimeMillis();
    }

    public ActionQueue getActionQueue() {
        return queue;
    }

    public void checkin() {
        this.queue.checkin(this);
    }

    @Override
    public final void run() {
        try {
            if (runable()) {
                long createTime = this.createTime;
                long start = System.currentTimeMillis();
                exec();
                long end = System.currentTimeMillis();
                Monitor.log(getClazz(), createTime, start, end, this);
            }
        } catch (Throwable e) {
            log.error("Execute exception: " + getClazz().getName(), e);
        } finally {
            queue.checkout(this);
            done();
        }
    }

    public final void runDirectly() {
        try {
            exec();
        } catch (Throwable e) {
            log.error("Direct run exception: " + getClazz().getName(), e);
        }
    }

    protected boolean runable() {
        return true;
    }

    protected void done() {
        // do nothing
    }

    protected abstract void exec();

    protected Class<?> getClazz() {
        return this.getClass();
    }

    public final int waitings() {
        return queue.size();
    }

    @Override
    public String toString() {
        return getClazz().getName() + " [" + DateTimeFormatter.ofPattern("MM-dd HH:mm:ss").format(ZonedDateTime.now()) + "]";
    }

}
