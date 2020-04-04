package com.java.thread;

public class SyncFunction {
    public static void main(String[] args) {
        //用Sync修饰的方法就是同步方法
        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                while (Ticket.currentCnt > 0) {
                    soldTicket();
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

    /**
     * 同步方法
     * 静态方法：同步锁就是 类锁 当前类.class
     * 非静态方法： 同步锁是 this
     */
    private synchronized static void soldTicket() {
        if (Ticket.currentCnt <= 0) return;
        System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + --Ticket.currentCnt);
    }
}
