package com.utils;

import java.util.*;

public class ListUtils {
    public static void main(String[] args) {
        initBinaryArray();
    }

    /**
     * getMaxValue
     *
     * @param arr Integer[]
     * @return int
     */
    public static int getMaxValue(Integer[] arr) {
        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        return list.stream().max(Comparator.comparingInt(a -> a)).get();
    }

    public static List<Integer> covertArrayToList(Integer[] a) {
        List<Integer> list = new ArrayList<>(a.length);
        Collections.addAll(list, a);
        return list;
    }

    public static void initBinaryArray() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}};
        int m = array[0].length;
        int n = array.length;

        System.out.println(m);
        System.out.println(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.printf("a[%s][%s] = %d, \n", i,j,array[i][j]);
            }
        }
    }
}
