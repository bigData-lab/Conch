package com.java.thread;

public class Productor extends Thread {

    private ProductPool pool;

    public Productor(ProductPool pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            String name = (int) (Math.random() * 100) + "号产品";
            System.out.println("生产了一个商品:" + name);
            Product product = new Product(name);
            this.pool.push(product);
        }
    }
}
