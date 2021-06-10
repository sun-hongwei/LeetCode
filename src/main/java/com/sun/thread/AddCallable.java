package com.sun.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author:xxx
 * @TODO:使用callable进行自增
 */
public class AddCallable {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        AddTask task01 = new AddTask("Task-01", 1, 50);
        AddTask task02 = new AddTask("Task-02", 51, 100);
        //得到的结果集
        Future<Long> resultSet01 = threadPool.submit(task01);
        Future<Long> resultSet02 = threadPool.submit(task02);
        try {
            System.out.println("最后的结果是：" + (resultSet01.get() + resultSet02.get()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        System.out.println(System.currentTimeMillis() - begin);
    }
};

/**
 * @author:xxx
 * @TODO:泛型中的Long表示返回的类型
 */
class AddTask implements Callable<Long> {
    private String name;
    private long begin;
    private long end;

    public AddTask(String name, long begin, long end) {
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Long call() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(name + " 执行中.......");
        long sum = 0;
        for (long i = begin; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
};
