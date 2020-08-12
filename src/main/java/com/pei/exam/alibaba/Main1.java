package com.pei.exam.alibaba;


import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        long[] right = new long[N];
        for (int i = N - 2; i >= 0; i--) {
            right[i] = Math.abs(arr[i] - arr[i + 1]) * (N - 1 - i) + right[i + 1];
        }

        long[] left = new long[N];
        for (int i = 1; i < N; i++) {
            left[i] = Math.abs(arr[i] - arr[i - 1]) * i + left[i - 1];
        }

        long ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            ans = Math.min(ans, left[i] + right[i]);
        }

        System.out.println(ans);
    }
}

/*

4
0 1 4 6

 */
