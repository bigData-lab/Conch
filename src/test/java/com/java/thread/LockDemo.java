package com.java.thread;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                while (Ticket.currentCnt > 0) {
                    lock.lock();
                    if (Ticket.currentCnt <= 0) return;
                    System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + --Ticket.currentCnt);
                    lock.unlock();
                }
            }
        };
        Thread t1 = new Thread(r, "thread-1");
        Thread t2 = new Thread(r, "thread-2");
        Thread t3 = new Thread(r, "thread-3");
        t1.start();
        t2.start();
        t3.start();
    }
}
