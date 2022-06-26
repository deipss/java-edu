package edu.java.deipss.pattern;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author deipss
 * @date 2021-11-12
 */
public class PolicyDemo {

    private RejectPolicy rejectPolicy;

    interface RejectPolicy {
        void run(Runnable runnable, ThreadPoolExecutor poll);
    }

    public static class CallerAbortPolicy implements RejectPolicy {

        @Override
        public void run(Runnable runnable, ThreadPoolExecutor poll) {
            runnable.run();
        }
    }

    public static class DiscardPolicy implements RejectPolicy {

        @Override
        public void run(Runnable runnable, ThreadPoolExecutor poll) {
            throw new RejectedExecutionException("");
        }
    }

    public void reject(Runnable runnable, ThreadPoolExecutor poll) {
        rejectPolicy.run(runnable, poll);
    }
}
