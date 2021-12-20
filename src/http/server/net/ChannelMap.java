package http.server.net;

import java.nio.channels.SelectionKey;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import http.server.task.LifeCycle;

public class ChannelMap {

    //Created a map object
    private static Map<SelectionKey, LifeCycle> MAP = null;

    static {
        if (null == MAP) {
            //created one of subclass of map interface as fully concurrent hashmap
            MAP = new ConcurrentHashMap<SelectionKey, LifeCycle>();
        }
    }

    private ChannelMap() {

    }

    //method for checking if the map contains specific Selectionkey corresponding to a channel
    public static boolean isContains(SelectionKey selectionKey) {
        return MAP.containsKey(selectionKey);
    }
    //method for putting selection key and lifecycle task in a map 
    public static LifeCycle put(SelectionKey selectionKey, LifeCycle task) {
        return MAP.put(selectionKey, task);
    }
    //method for get lifecycle task
    public static LifeCycle get(SelectionKey selectionKey) {
        return MAP.get(selectionKey);
    }
    //method for remove a selection key in a key set
    public static LifeCycle remove(SelectionKey selectionKey) {
        return MAP.remove(selectionKey);
    }

}
