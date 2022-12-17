package com.leetcode;

/**
 * https://leetcode.cn/problems/find-the-highest-altitude/
 * <p>
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。
 * 自行车手从海拔为 0 的点 0 开始骑行。
 * <p>
 * 给你一个长度为 n 的整数数组 gain ，
 * 其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 */
public class Num_1732 {

    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        int result = largestAltitude(gain);
        System.out.println(result);
    }


    public static int largestAltitude(int[] gain) {
        Integer[] result = new Integer[gain.length + 1];
        result[0] = 0;
        int maxValue = result[0];
        for (int i = 0; i < gain.length; i++) {
            // 下一个海拔等于前一个海拔加上差距（后一个和前一个的差距）
            result[i + 1] = result[i] + gain[i];
            maxValue = Math.max(maxValue, result[i + 1]);
        }
        return maxValue;
    }
}
