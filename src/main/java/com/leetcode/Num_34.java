package com.leetcode;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 * 你必须设计并实现时间复杂度为(log n)的算法解决此问题。
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class Num_34 {

    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 3;

        Num_34 num_34 = new Num_34();
        int[] result = num_34.searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        // 找匹配值的左边界，每次匹配到的时候 right = middle - 1
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                right = middle - 1;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        if (left >= 0 && left <= nums.length - 1 && nums[left] == target) {
            result[0] = left;
        } else {
            result[0] = -1;
        }

        left = 0;
        right = nums.length - 1;
        // 找匹配值的右边界，每次匹配到的时候 left = middle + 1
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                left = middle + 1;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        if (right >= 0 && right <= nums.length - 1 && nums[right] == target) {
            result[1] = right;
        } else {
            result[1] = -1;
        }
        return result;
    }

}
