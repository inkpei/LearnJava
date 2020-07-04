package com.pei.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description: TODO
 * @Data: 2020/4/4
 */
public class ArrUtil {

    public static int seed = 4001;


    public static void print(int[] arr) {
        System.out.println("// " + Arrays.toString(arr));
    }
    public static void print(int[][] arrs) {
        for (int[] arr: arrs) {
            System.out.println("// " + Arrays.toString(arr));
        }
    }

    public static int[] getArr(String s,String c) {
        String[] s1 = s.split(c);
        int[] res = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            res[i] = Integer.parseInt(s1[i]);
        }

        return res;
    }

    public static int[] getArr(String s) {
        return getArr(s, ",");
    }




        public static int[] getArr(int n, int bound, boolean isDup, boolean isSort) {
        int[] res = new int[n];
        Random random = new Random(seed);
        if (isDup) {
            for (int i = 0; i < n; i++) {
                res[i] = random.nextInt(bound);
            }
        } else {
            HashSet<Integer> set = new HashSet<>();
            while (set.size() < n) {
                set.add(random.nextInt(bound));
            }
            Object[] objects = set.toArray();

            for (int i = 0; i < n; i++) {
                res[i] = (Integer) objects[i];
            }

        }
        if (isSort) Arrays.sort(res);
        return res;
    }

    public static int[] getArr(int n) {
        return getArr(n, 10, true, false);
    }

    public static int[] getArr(int n, int bound) {
        return getArr(n, bound, true, false);
    }

    public static int[] getArr(int n, int bound, boolean isDup) {
        return getArr(n, bound, isDup, false);
    }

    public static int[][] getArrs(int m, int n, int bound, boolean isDup, boolean isSort) {

        int[][] ints = new int[m][];
        for (int i = 0; i < m; i++) {
            seed = seed + i;
            ints[i] = getArr(n, bound, isDup, isSort);
        }
        return ints;

    }

    public static int[][] getArrs(int m, int n) {

        return getArrs(m,n,10,true,false);
    }

    public static int[][] getArrs(int m, int n, int bound) {

        return getArrs(m,n,bound,true,false);

    }

    public static int[][] getArrs(int m, int n, boolean isDup) {
        return getArrs(m,n,10,isDup,false);
    }




    public static void main(String[] args) {

    }

}
