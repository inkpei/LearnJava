package com.pei.demo.sort;

import java.util.ArrayList;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description: 基数排序
 * @Data: 2020/6/22
 */
public class RadixSort implements Sort {
    @Override
    public void sort(int[] arr) {
        int digit = getMaxDigit(arr); // 获取最大的数是多少位
        for (int i = 0; i < digit; i++) {
            bucketSort(arr, i); // 执行 digit 次 bucketSort 排序即可
        }

    }


    public static int getMaxDigit(int[] arr) {
        int digit = 1; // 默认只有一位
        int base = 10; // 十进制每多一位，代表其值大了10倍
        for (int i : arr) {
            while (i > base) {
                digit++;
                base *= 10;
            }
        }
        return digit;
    }

    public static void bucketSort(int[] arr, int digit) {
        int base = (int) Math.pow(10, digit);
        // init buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) { // 只有0~9这十个数，所以准备十个桶
            buckets.add(new ArrayList<>());
        }
        // sort
        for (int i : arr) {
            int index = i / base % 10;
            buckets.get(index).add(i);
        }
        // output: copy back to arr
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int i : bucket) {
                arr[index++] = i;
            }
        }
    }

}
