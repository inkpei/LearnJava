package com.pei.leetcode.sort;

import java.util.Arrays;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description:
 * @Data: 2020/6/22
 */
public class InsertSort implements Sort {
    @Override
    public void sort(int[] arr) {
        for (int i =0; i < arr.length; i++){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[i]){
                    int tmp = arr[i];
                    System.arraycopy(arr,j,arr,j+1,i-j);
                    arr[j] = tmp;
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Sort sort = new InsertSort();
        int[] arr = Util.initArr(10);
        System.out.println(Arrays.toString(arr));
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
