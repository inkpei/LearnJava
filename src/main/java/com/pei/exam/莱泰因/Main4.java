package com.pei.exam.莱泰因;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        arr = Arrays.stream(s.substring(1, s.length() - 1).split(",")).mapToInt(Integer::parseInt).toArray();
        long sum = Arrays.stream(arr).sum();
        getMax(0, arr.length - 1, sum);
        System.out.println(max);

    }

    static int[] arr;
    static long max = Integer.MIN_VALUE;

    static void getMax(int left, int right, long sum) {
        if (left > right) return;
        max = Math.max(max, sum);
        if (arr[left] < arr[right]) {
            getMax(left + 1, right, sum - arr[left]);
        } else if (arr[left] > arr[right]) {
            getMax(left, right - 1, sum - arr[right]);
        } else {
            getMax(left + 1, right, sum - arr[left]);
            getMax(left, right - 1, sum - arr[right]);
        }

    }
}
