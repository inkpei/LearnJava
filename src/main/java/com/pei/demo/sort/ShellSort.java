package com.pei.demo.sort;

import java.util.Arrays;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description:
 * @Data: 2020/6/22
 */
public class ShellSort implements Sort {

    public static void main(String[] args) {
        Sort sort = new ShellSort();
        int[] arr = Util.initArr(10);
        System.out.println(Arrays.toString(arr));
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }



    @Override
    public  void sort(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j;
                int tmp = arr[i];
                //插入排序
                for (j = i; j >= gap && tmp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = tmp;
            }
        }
    }
}
