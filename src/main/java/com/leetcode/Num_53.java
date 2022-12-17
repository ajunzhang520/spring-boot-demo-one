package com.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class Num_53 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxValue = maxSubArray(nums);
        System.out.println(maxValue);
    }

    public static int maxSubArray(int[] nums) {
        int[] areaSum = new int[nums.length];
        areaSum[0] = nums[0];
        int maxValue = areaSum[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果num[i] 比前面累计加的还大，就相当于新的连续数组从i开始了
            areaSum[i] = Math.max(areaSum[i - 1] + nums[i], nums[i]);
            maxValue = Math.max(maxValue, areaSum[i]);
        }
        return maxValue;
    }
}
