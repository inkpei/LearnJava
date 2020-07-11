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

    public static int findLR(int[] arr, int target, int left, int right) {
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

    public static int findLR(int[] arr, int target) {
        return findLR(arr, target, 0, arr.length);
    }


    public static int findRR(int[] arr, int target, int left, int right) {
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

    public static int findRR(int[] arr, int target) {
        return findRR(arr, target, 0, arr.length);
    }


    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 3, 5, 7, 7, 7, 7, 7, 7, 9};

        System.out.println(findLR(ints, 15));
        System.out.println(findRR(ints, 15));
        System.out.println(findLR(ints, -5));
        System.out.println(findRR(ints, -5));

    }
}
