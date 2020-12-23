package com.sun.leetcode;

/**
 * LeetCode 第一题 两数之和
 */
public class SumOfTwoNumbers {

    public static void main(String[] args) {

        int[] nums = {3, 2, 4};
        int target = 6;

        int[] ints = twoSum(nums, target);
        System.out.println(ints[0] + "-----" + ints[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
