package com.leetcode;

public class FindMIddleNum {


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
