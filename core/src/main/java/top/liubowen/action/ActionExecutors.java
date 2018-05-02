package top.liubowen.action;

import top.liubowen.tools.ThreadPoolActionExecutor;

import java.util.ArrayList;
import java.util.List;

public class ActionExecutors {

    private final static List<ActionExecutor> executors = new ArrayList<ActionExecutor>();

    public static ActionExecutor newSingle(String name) {
        return new ThreadPoolActionExecutor(1, 1, name);
    }

    public static ActionExecutor newFixed(String name, int nThreads) {
        return new ThreadPoolActionExecutor(nThreads, nThreads, name);
    }

    /**
     * @param name
     * @param nThreads,
     *            maxThreads use double nThreads
     * @return
     */
    public static ActionExecutor newCached(String name, int nThreads) {
        return newCached(name, nThreads, nThreads * 3);
    }

    public static ActionExecutor newCached(String name, int nThreads, int maxThreads) {
        return new ThreadPoolActionExecutor(maxThreads, maxThreads, name);
    }

    public static void shutdown() {
        for (ActionExecutor executor : executors) {
            executor.shutdown();
        }
    }

    public static List<ActionExecutor> getExecutors() {
        return executors;
    }

    public static void add(ActionExecutor actionExecutor) {
        executors.add(actionExecutor);
    }

}
