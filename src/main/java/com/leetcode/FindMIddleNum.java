package com.leetcode;

public class FindMIddleNum {

    /**
     * 思路为把两个数组看作一个数组，加入两个数组长度为len，则中位数为len/2, 这里存在一个奇数和偶数的问题
     * 奇数则直接取len/2这个元素即可，偶数需要取这个数和前一个数再除以2
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        int middle = (m + n) / 2;

        int aIndex = 0;
        int bIndex = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i <= middle; i++) {
            left = right;
            // aIndex比m要小，同时bIndex已经大于等于n了或者每次再取元素的时候比较一下哪个小一些，就从哪个数组取
            if (aIndex < m && (bIndex >= n || A[aIndex] < B[bIndex])) {
                right = A[aIndex];
                aIndex++;
            } else {
                right = B[bIndex];
                bIndex++;
            }
        }

        if ((m + n) % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

}
