package http.server.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import http.server.bean.Const;

public class LifeCycleExecution {
    private static final Logger LOG = Logger.getLogger(LifeCycleExecution.class.getName());

    private static ExecutorService EXECUTORS = null;

    static {
        if (null == EXECUTORS) {
            EXECUTORS = Executors.newFixedThreadPool(Const.THREAD_POOL_SIZE);
        }
    }

    private LifeCycleExecution() {
    }

    public static void shutdown() {
        EXECUTORS.shutdown();
    }

    public static void sumbit(LifeCycle lifeCycle) {
        EXECUTORS.submit(lifeCycle);
        LOG.log(Level.INFO, "submit a new life cycle");
    }

}
