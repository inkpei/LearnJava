package com.pei.leetcode.find;

public class HalfFind {

    // 查找 target 下标
    public static int find(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 查找最后一个小于等于 target 的下表
    public static int findLastLE(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == 0) {

            return -1;
        }
        return left - 1;
    }

    // 查找第一个大于等于 target 的下表
    public static int findLastGE(int[] array, int target) {
        int start = 0;
        int right = array.length - 1;
        while (start <= right) {
            int mid = (start + right) / 2;
            if (array[mid] < target)
                start = mid + 1;
            else
                right = mid - 1;
        }
        if (right == array.length - 1)
            return -1;
        return right + 1;

    }
}
