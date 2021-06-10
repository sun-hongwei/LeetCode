package com.sun.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread3 {
    //三个线程
    static final int taskSize = 3;
    //创建一个线程池
    static final ExecutorService pool = Executors.newFixedThreadPool(taskSize);

    public static void main(String[] args) {
        while (true) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is running");
            });
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
