package top.liubowen.event;

/**
 * 
 * 事件
 * @author luzj
 * 
 */
public abstract class Event {
    
    private int eventType;
    //标识是否其他进程来的Event, 如果是不需要再次传递
    private boolean remote; 
    
    public Event(int eventType) {
        this.eventType = eventType;
    }
    
    public int eventType() {
        return this.eventType;
    }
    
    public boolean isRemote() {
        return remote;
    }

    public Event asRemote() {
        this.remote = true;
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T extends Event> T cast() {
        return (T) this;
    }

}
