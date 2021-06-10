package com.sun.thread;


import java.util.HashSet;

public class Test {
    public static void main(String[] args) {
        Integer integer = new Integer(0);
        HashSet set = new HashSet();
        set.add(2);
        if (set.contains(1)) {
            System.out.println("have");
        } else {
            System.out.println("no have");
        }
        System.out.println(set.size());
        System.out.println(integer);
    }
}
