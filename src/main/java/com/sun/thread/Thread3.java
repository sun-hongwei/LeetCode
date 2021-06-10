package com.sun.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池及变量原子性
 */
public class Thread3 {
    //三个线程
    static final int taskSize = 3;
    //创建一个线程池
    static final ExecutorService pool = Executors.newFixedThreadPool(taskSize);

//    static AtomicInteger atomicInteger = new AtomicInteger(0);

    static Integer atomicInteger = new Integer(0);

    static Set set = new HashSet();

    public static void main(String[] args) {
        //while (true) {
        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " is running");
            addNum();
        });

        pool.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " is running");
            addNum();
        });

        pool.execute(() -> {
            printNum();
        });

        pool.execute(() -> {
            while (true) {
                System.out.println("我是线程第四");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //}
    }

    private static void printNum() {
        while (true) {
//            System.out.println(atomicInteger.get());
            System.out.println(atomicInteger);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addNum() {
        while (true) {
            if (set.contains(atomicInteger)) {
                System.out.println("有重复KEY");
                throw new RuntimeException("有重复KEY");
            }
//            set.add(atomicInteger.getAndIncrement());
            atomicInteger += 1;
            set.add(atomicInteger);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
