package com.sun.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized
 */
public class synchronized1 {
    static int i = 0;
    public static synchronized int getNum() {
        return i += 1;
    }

    //三个线程
    static final int taskSize = 3;
    //创建一个线程池
    static final ExecutorService pool = Executors.newFixedThreadPool(taskSize);

    public static void main(String[] args) {
        while (true) {
            pool.execute(() -> {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "-------" + getNum());
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}