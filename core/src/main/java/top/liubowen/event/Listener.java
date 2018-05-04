package top.liubowen.event;

@FunctionalInterface
public interface Listener<T extends Event> {

    void onEvent(T event);

}
