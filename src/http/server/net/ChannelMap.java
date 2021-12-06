package http.server.net;

import java.nio.channels.SelectionKey;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import http.server.task.LifeCycle;

public class ChannelMap {

    private static Map<SelectionKey, LifeCycle> MAP = null;

    static {
        if (null == MAP) {
            MAP = new ConcurrentHashMap<SelectionKey, LifeCycle>();
        }
    }

    private ChannelMap() {

    }

    public static boolean isContains(SelectionKey selectionKey) {
        return MAP.containsKey(selectionKey);
    }

    public static LifeCycle put(SelectionKey selectionKey, LifeCycle task) {
        return MAP.put(selectionKey, task);
    }

    public static LifeCycle get(SelectionKey selectionKey) {
        return MAP.get(selectionKey);
    }

    public static LifeCycle remove(SelectionKey selectionKey) {
        return MAP.remove(selectionKey);
    }

}
