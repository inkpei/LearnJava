package com.pei.leetcode;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description:
 * @Data: 2020/6/22
 */

public
class Solution { //动态规划 5ms 99.82 %
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {  //沙雕测试用例[]
            return 0;
        }
        int[] points = new int[nums.length + 2];
        System.arraycopy(nums, 0, points, 1, nums.length);
        points[0] = 1;
        int N = points.length;
        points[N - 1] = 1;
        int[][] dp = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], points[i] * points[j] * points[k] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
