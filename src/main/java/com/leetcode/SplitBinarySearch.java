package com.leetcode;

/**
 * https://leetcode.cn/problems/search-in-rotated-sorted-array/submissions/
 */
public class SplitBinarySearch {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        SplitBinarySearch splitBinarySearch = new SplitBinarySearch();
        int index = splitBinarySearch.search(nums, target);
        System.out.println(index);
    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 0) {
            return -1;
        }

        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            // 判断根据middle切割，哪边子数组是升序的。如果nums[0] < nums[middle],则middle左边是升序，否则middle右边是升序
            if (nums[0] <= nums[middle]) {
                // 二分搜索，如果target比索引middle所在值还要小，说明右指针要左移
                if (nums[0] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // 如果target比索引middle所在值还要大，说明左指针要右移
                if (nums[middle] < target && target <= nums[nums.length - 1]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

        }
        return -1;
    }
}
