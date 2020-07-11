package com.pei.leetcode.example;

public class StockTrade {

    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
        dp[1] = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }


    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfit2(int[] prices) {
        int[] dp = new int[2];
        dp[1] = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], tmp - prices[i]);
        }
        return dp[0];
    }


    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;
        int dp0 = 0;
        int dp1 = Integer.MIN_VALUE;

        int pre = 0;

        for (int i = 0; i < n; i++) {
            int tmp = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, pre - prices[i]);
            pre = tmp;
        }

        return dp0;
    }

    // https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n < 1 || k < 0) return 0;

        // 退化为不限次数的交易了
        if (k > n / 2) {
            return maxProfit(prices);
        }

        int[][][] dp = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }

            }

        }
        return dp[n - 1][k][0];

    }

    //https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    public int maxProfit4(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[1] = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int tmp = dp[0];
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            // 必须在买入时扣取交易费
            dp[1] = Math.max(dp[1], tmp - prices[i] - fee);
        }
        return dp[0];
    }


}
