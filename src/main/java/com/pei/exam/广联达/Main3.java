package com.pei.exam.广联达;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        double[][] cost = new double[N][2];
        double[][] dp = new double[C + 1][N];
        for (int i = 0; i < N; i++) {
            String[] arr = scanner.nextLine().split(" ");
            cost[i][0] = Double.parseDouble(arr[0]);
            cost[i][1] = Double.parseDouble(arr[1]);
        }
        double max = 0;

        for (int i = 0; i <= C; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    dp[i][j] = cost[j][0] <= i ? cost[j][1] : 0;
                } else {
                    if (cost[j][0] <= i) {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[(int) Math.floor(i - cost[j][0])][j - 1] + cost[j][1]);
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
                max = Math.max(max, dp[i][j]);
            }

        }

        System.out.println((int) max);
    }
}
