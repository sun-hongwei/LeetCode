package com.sun;

import redis.clients.jedis.Jedis;

public class Test {

    public static void main(String[] args) {
        //连接redis服务器(在这里是连接本地的)
        Jedis jedis = new Jedis("122.112.174.92", 6379);
        //权限认证
        jedis.auth("112233");

        System.out.println(jedis.get("TThread-36615"));
    }
}
