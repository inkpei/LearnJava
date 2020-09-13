package com.pei.exam.拼多多;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] good = new int[N][2];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            good[i][0] = scanner.nextInt();
            good[i][1] = scanner.nextInt();
            if (good[i][0] < 0) {
                ans += good[i][1];
                M -= good[i][0];
                good[i][0] = -good[i][0];
                good[i][1] = -good[i][1];
            }
        }
        int[] dp = new int[M + 1];
        for (int[] ints : good) {
            for (int i = M; i >= ints[0]; i--) {
                dp[i] = Math.max(dp[i], dp[i - ints[0]] + ints[1]);
            }
        }
        System.out.println(dp[M] + ans);
    }
}
