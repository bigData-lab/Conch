package com.java.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        Executors.newScheduledThreadPool(1);
        Executors.newFixedThreadPool(1);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newWorkStealingPool();
    }
}
