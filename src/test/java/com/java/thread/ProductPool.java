package com.java.thread;

import java.util.LinkedList;
import java.util.List;

public class ProductPool {
    //存储有所有产品的集合，生产者生产产品，往这个集合添加元素，消费者消费产品，从这个集合取出元素

    private List<Product> productList;

    private int maxSize = 10;

    public ProductPool(int maxSize) {
        this.productList = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public synchronized void push(Product product) {
        //判断是否还需生产
        if (this.productList.size() == maxSize) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //add product
        this.productList.add(product);
        // 通知其他人，有产品可以消费了
        this.notifyAll();
    }

    /**
     * 消费者从商品池中取出一个商品进行消费
     *
     * @return
     */
    public synchronized Product pop() {
        if(this.productList.size()==0){
            //判断是否还有商品
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //从商品池取出一个商品
        Product product = this.productList.remove(0);
        this.notifyAll();
        return product;
    }
}
