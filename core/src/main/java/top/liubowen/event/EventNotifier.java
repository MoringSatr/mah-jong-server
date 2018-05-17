package top.liubowen.event;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * @author: liubowen
 * @date: 2018/5/11 18:01
 * @description: 事件容器
 */
@Slf4j
public class EventNotifier implements ListenerRegistrator {

    private ListMultimap<Integer, EventListener> listeners;

    public EventNotifier() {
        listeners = ArrayListMultimap.create();
    }

    @Override
    public synchronized void register(EventListener listener) {
        listeners.put(listener.eventType(), listener);
    }

    public void notify(Event event) {
        List<EventListener> list = listeners.get(event.eventType());
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        list.forEach(listener -> {
            try {
                listener.onEvent(event);
            } catch (Exception e) {
                log.error("notify event exception , listener name: {}:", listener.getClass().getName(), e);
            }
        });
    }

}
