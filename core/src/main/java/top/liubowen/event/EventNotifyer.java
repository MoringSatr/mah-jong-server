package top.liubowen.event;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * 事件容器
 * 
 * @author luzj
 *
 */
@Slf4j
public class EventNotifyer implements ListenerRegistrator {

    private Map<Integer, List<EventListener>> listeners;

    public EventNotifyer() {
        listeners = Maps.newHashMap();
    }

    public synchronized void registListener(EventListener listener) {
        int eventType = listener.eventType();
        List<EventListener> list = this.listeners.get(eventType);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            this.listeners.put(eventType, list);
        }

        list.add(listener);
    }

    public void notifyEvent(Event event) {
        List<EventListener> list = this.listeners.get(event.eventType());
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        for (EventListener eventListener : list) {
            try {
                eventListener.onEvent(event);
            } catch (Exception e) {
                log.error("Notify event:", e);
            }
        }
    }

    public synchronized void unregistListener(int unregistOccasion) {
        Collection<List<EventListener>> values = listeners.values();
        for (List<EventListener> list : values) {
            if (CollectionUtils.isEmpty(list)) {
                continue;
            }
            for (Iterator<EventListener> it = list.iterator(); it.hasNext();) {
                EventListener next = it.next();
                if (next.unregistOccasion() == unregistOccasion) {
                    list.remove(next);
                }
            }
        }
    }

    public synchronized void unregistListener(EventListener listener) {
        List<EventListener> list = listeners.get(listener.unregistOccasion());
        if (!CollectionUtils.isEmpty(list))
            list.remove(listener);
    }

    @Override
    public void regist(EventListener listener) {
        registListener(listener);
    }

}
