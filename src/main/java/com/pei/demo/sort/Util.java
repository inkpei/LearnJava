package com.pei.demo.sort;

import java.util.Random;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description:
 * @Data: 2020/6/22
 */
public class Util {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] initArr(int n) {
        Random random = new Random();
       return random.ints(0, 10 * n).limit(n).toArray();
    }
}
