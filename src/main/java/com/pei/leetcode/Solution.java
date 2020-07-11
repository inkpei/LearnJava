package com.pei.leetcode;

import java.util.Arrays;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description:
 * @Data: 2020/6/22
 */

public
class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] ans = new int[N];
        if (paths.length < 1) {
            Arrays.fill(ans, 1);
            return ans;
        }
        int[][] arr = new int[N][N];
        for (int[] path : paths) {
            arr[path[0] - 1][path[1] - 1] = -1;
            arr[path[1] - 1][path[0] - 1] = -1;
        }


        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i][j] == -1) count++;

            }
            ans[i] = count;
        }
        return ans;
    }
}
