package com.pei.exam.wanmei;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[] cost = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] value = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] dp = new int[size + 1];
        for (int i = 0; i < cost.length; i++) {
            for (int j = size; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + value[i]);
            }
        }
        System.out.println(dp[size]);

    }
}
