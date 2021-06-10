package com.sun.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Thread4 {

    /**
     * 延迟启动线程
     */
    static final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

    public static void main(String[] args) {
        scheduledExecutorService.schedule(() -> {
            System.out.println("延迟三秒执行");
            System.out.println(Thread.currentThread().getName() + " is running");
        }, 3, TimeUnit.SECONDS);
    }


}
