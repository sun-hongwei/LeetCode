package com.sun.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName:Skeleton
 * @PackageName:com.comtop.test
 * @Verson :0.1
 * @CreateUser :lanweixing
 * @CreateDate :2014-9-3上午9:41:16
 * @UseFor :
 */
public class DoThread {

    public static void main(String[] args) {

        List<Num> list = new ArrayList<Num>();
        List<Message> result1 = new ArrayList<Message>();
        List<Message> result = new ArrayList<Message>();
        // ExecutorService pool = Executors.newCachedThreadPool() ;
        //使用线程池处理
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 4, 3000L,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(2));

        for (int i = 0; i < 1000000; i++) {
            list.add(new Num(i));
        }
        long begin = System.currentTimeMillis();
        try {
            //1000000条数据5个线程跑   每个线程跑集合中的一部分
            for (int i = 0; i < 5; i++) {
                result1 = pool.submit(
                        new Main4Thread(list, i * 200000, (i + 1) * 200000))
                        .get();
                result.addAll(result1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
        System.out.println("所用时间" + (System.currentTimeMillis() - begin));
        System.out.println(result.size());
    }
};

class Main4Thread implements Callable<List<Message>> {
    private List<Num> num;
    private int begin;
    private int end;

    /**
     * @param num
     */
    Main4Thread(List<Num> num, int begin, int end) {
        super();
        this.num = num;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public List<Message> call() throws Exception {

        List<Message> msgList = new ArrayList<Message>();
        for (int i = begin; i < end; i++) {
            if (num.get(i).getAge() >= 500000) {
                //线程逻辑处理
                Message msg = new Message();
                msg.setMsg(num.get(i).getAge() + " Too old");
                msgList.add(msg);
            }
        }
        System.out.println(Thread.currentThread().getName());
        return msgList;
    }

};

class Message {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

};

class Num {
    private int age;

    /**
     * @param age
     */
    Num(int age) {
        super();
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

};
