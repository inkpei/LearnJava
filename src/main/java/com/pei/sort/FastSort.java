package com.pei.sort;

import java.util.Arrays;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description: 快排
 * @Data: 2020/6/22
 */
public class FastSort implements Sort {


        private void fastSort(int[] arr, int low, int high) {
        if (low > high) return;
        int flag = arr[low];
        int i = low + 1;
        int j = high;
        while (true) {
            while (i <= high && arr[i] <= flag) {
                i++;
            }
            while (j >= low && arr[j] > flag) {
                j--;
            }
            if (i < j) {
                Util.swap(arr, i, j);
            } else {
                break;
            }
        }
        Util.swap(arr, low, j);
        fastSort(arr, low, j - 1);
        fastSort(arr, j + 1, high);
    }

    public static void main(String[] args) {
        Sort sort = new FastSort();
        int[] arr = Util.initArr(10);
        System.out.println(Arrays.toString(arr));
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        fastSort(arr, 0, arr.length - 1);
    }
}
