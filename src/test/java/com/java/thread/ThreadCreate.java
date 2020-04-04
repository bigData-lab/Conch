package com.java.thread;

public class ThreadCreate {

    public static void main(String[] args) {
        //线程实例化
        //1，继承Thread类，做一个线程子类

        MyThread mt = new MyThread();
        //需要调用start方法，来执行run中逻辑
        //start会开启一个新的线程，来执行run中逻辑
        //如果直接调用run，mt不会进入就绪状态
        mt.start();
        System.out.println("主线程中逻辑执行结束了");

        Runnable r = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("线程2中的逻辑：" + i);
            }
        };
        Thread t2 = new Thread(r);
        t2.start();
    }
}

/*
可读性强
 */
class MyThread extends Thread {

    /**
     * 将需要并发执行的任务写到run方法
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程中的逻辑：" + i);
        }

    }
}
