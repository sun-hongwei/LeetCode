package com.sun.leetcode;

/**
 * LeetCode 第七题 整数翻转
 */
public class Seven_IntegerFlip {

    public static void main(String[] args) {
        int x = 123;
        int reverse = reverse(x);
        System.out.println(reverse);
    }

    /**
     * 123
     * 3 2 1
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }
}
