package com.pei.exam.kedaxunfei;


import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            tmp[i] = arr[i];
        }
        mergeSort(arr, 0, n - 1);
//        for (int i = 0; i < n; i++) {
//            fast(tmp, arr[i]);
//            System.out.println(Arrays.toString(tmp));
//        }
    }


    static void fast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && arr[left] < target) left++;
            while (left < right && arr[right] > target) right--;
            swap(arr, left, right);
        }
        arr[left] = target;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

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
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

}

/*
9
25 84 21 47 15  27 68 35 20

 */
