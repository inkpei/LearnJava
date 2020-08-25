package com.pei.demo.sort;

import java.util.Arrays;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description: 归并排序
 * @Data: 2020/6/22
 */
public class MergeSort implements Sort {

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= high) temp[k++] = arr[j++];
        if (temp.length >= 0) System.arraycopy(temp, 0, arr, low, temp.length);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Sort sort = new MergeSort();
        int[] arr = Util.initArr(10);
        System.out.println(Arrays.toString(arr));
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }
}
