package top.liubowen.event;

@FunctionalInterface
public interface Listener<T extends Event> {
    
    public void onEvent(T event);

}
