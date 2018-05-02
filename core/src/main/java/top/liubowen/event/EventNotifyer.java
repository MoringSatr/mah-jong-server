package top.liubowen.event;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.hoolai.util.collection.CollectionUtil;
import com.hoolai.util.collection.IntHashMap;
import com.hoolai.util.log.Log;

/**
 * 
 * 事件容器
 * @author luzj
 *
 */
public class EventNotifyer implements ListenerRegistrator {
    
    private IntHashMap<List<EventListener>> listeners;
    
    public EventNotifyer() {
        listeners = new IntHashMap<List<EventListener>>();
    }
    
    public synchronized void registListener(EventListener listener) {
        int eventType = listener.eventType();
        List<EventListener> list = this.listeners.get(eventType);
        if(list == null) {
            list = new CopyOnWriteArrayList<>();
            this.listeners.put(eventType, list);
        }
        
        list.add(listener);
    }
    
    public void notifyEvent(Event event) {
        List<EventListener> list = this.listeners.get(event.eventType());
        if(CollectionUtil.isEmpty(list)) {
            return;
        }
        for (EventListener eventListener : list) {
            try {
                eventListener.onEvent(event);
            } catch (Exception e) {
                Log.error("Notify event:", e);
            }
        }
    }

	public synchronized void unregistListener(int unregistOccasion) {
	    Collection<List<EventListener>> values = listeners.values();
	    for (List<EventListener> list : values) {
	        if(CollectionUtil.isEmpty(list)) {
	            continue;
	        }
            for(Iterator<EventListener> it = list.iterator(); it.hasNext();) {
                EventListener next = it.next();
                if(next.unregistOccasion() == unregistOccasion) {
                    list.remove(next);
                }
            }
        }
	}
	
	public synchronized void unregistListener(EventListener listener) {
        List<EventListener> list = listeners.get(listener.unregistOccasion());
        if(!CollectionUtil.isEmpty(list))
            list.remove(listener);
    }

    @Override
    public void regist(EventListener listener) {
        registListener(listener);
    }

}
