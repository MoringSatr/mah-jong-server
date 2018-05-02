package top.liubowen.event;

/**
 * 事件监听
 * 
 * @author luzj
 */
public abstract class EventListener {

    private int unregistOccasion;
    private final int eventType;

    public EventListener(int eventType) {
        this.eventType = eventType;
    }

    public abstract void onEvent(Event event);

    public int eventType() {
        return this.eventType;
    }

    public int unregistOccasion() {
        return unregistOccasion;
    }

    public EventListener withUnregistOccasion(int unregistOccasion) {
        this.unregistOccasion = unregistOccasion;
        return this;
    }

    public static <T extends Event> EventListener of(int eventType, Listener<T> listener) {
        return new FuncEventListener<>(eventType, listener);
    }

    static class FuncEventListener<T extends Event> extends EventListener {
        final Listener<T> listener;

        public FuncEventListener(int eventType, Listener<T> listener) {
            super(eventType);
            this.listener = listener;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void onEvent(Event event) {
            listener.onEvent((T) event);
        }
    }

}
