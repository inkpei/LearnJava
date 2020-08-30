package com.pei.leetcode.sort;

import java.util.Arrays;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description:
 * @Data: 2020/6/22
 */
public class SimpleSelectSort implements Sort {
    @Override
    public void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int min = i; // 将当前下标定义为最小值下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) { // 如果有小于当前最小值的关键字, 则将此关键字的下标赋值给min
                    min = j;
                }
            }
            if (i != min) { // 若min不等于i，说明找到最小值，交换
                Util.swap(arr, i, min);
            }
        }

    }

    public static void main(String[] args) {
        Sort sort = new SimpleSelectSort();
        int[] arr = Util.initArr(10);
        System.out.println(Arrays.toString(arr));
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
