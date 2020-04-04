package com.java.thread;

public class Program {
    public static void main(String[] args) {
        ProductPool pool = new ProductPool(15);
        new Productor(pool).start();
        new Consumer(pool).start();

    }
}

