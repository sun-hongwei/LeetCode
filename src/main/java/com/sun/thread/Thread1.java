package com.sun.thread;

public class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("---");
    }
}

class Main1 {

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
    }
}