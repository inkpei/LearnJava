package com.pei.exam.aiqixin;

public class Main2 {

    public static void main(String[] args) {
        System.out.println(new Solution().reletive_7(new int[]{1, 1, 2}));
    }
}

class Solution {
    int count = 0;

    public int reletive_7(int[] digit) {
        // write code here
        trace(digit, 0);
        return count;
    }

    void trace(int[] arr, int index) {
        if (index >= arr.length) {
            StringBuilder bu = new StringBuilder();
            for (int i : arr) {
                bu.append(i);
            }
            if (Integer.parseInt(bu.toString()) % 7 == 0) count++;
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            trace(arr, index + 1);
            swap(arr, index, i);
        }
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
