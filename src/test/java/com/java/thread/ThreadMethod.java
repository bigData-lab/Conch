package com.java.thread;

public class ThreadMethod {
    public static void main(String[] args) {
        MyThread2 t = new MyThread2();
        t.setName("custom");

//        System.out.println(t.getName());
        threadPriority();
    }

    private static void sleepThread() {
        MyThread2 t = new MyThread2();
        t.start();
    }

    private static void threadPriority() {
        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
                //对象锁：
                //类锁
                //需要保证一点：多个线程看到的锁，需要是同一把锁
                //同步代码段解决临界资源问题
                synchronized (ThreadMethod.class) {
                    while (Ticket.currentCnt > 0) {
                        System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + --Ticket.currentCnt);
                    }
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

class Ticket {
    static int currentCnt = 100;
}

class MyThread2 extends Thread {

    public MyThread2() {
    }

    public MyThread2(String s) {
        this.setName(s);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            // 毫秒为单位
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}