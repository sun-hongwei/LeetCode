package com.sun.leetcode;


/**
 * LeetCode 第九题 回文数
 */
public class Nine_PalindromicNumber {

    public static void main(String[] args) {
        int x = 121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }
}
