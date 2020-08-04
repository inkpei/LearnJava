package com.pei.leetcode.util;

public class HalfFind {


    public static int find(int[] arr, int target, int left, int right) {
        if (arr.length == 0 || left > right) return -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int find(int[] arr, int target) {
        return find(arr, target, 0, arr.length - 1);
    }

    public static int findUpper(int[] arr, int target, int left, int right) {
        if (arr.length == 0 || left > right) return -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                right = mid;
            } else if (arr[mid] > target) {
                right = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int findUpper(int[] arr, int target) {
        return findUpper(arr, target, 0, arr.length);
    }


    public static int findDowner(int[] arr, int target, int left, int right) {
        if (arr.length == 0 || left > right) return -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static int findDowner(int[] arr, int target) {
        return findDowner(arr, target, 0, arr.length);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 6, 9, 11};
        System.out.println(arr[findUpper(arr, 10)]);
        System.out.println(arr[findDowner(arr, 10)]);
    }
}
