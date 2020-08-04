package com.pei.exam.aiqixin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - arr[i][0] > 0) {
                    dp[j] = Math.max(dp[j - arr[i][0]] + arr[i][1], dp[j]);
                }
            }
        }
        System.out.println(dp[target]);
    }
}
