package com.pei.exam.bilibili;

import java.util.HashMap;
import java.util.LinkedList;

public class Main1 {
    class Solution {

        boolean flag = false;

        public boolean Game24Points(int[] arr) {
            // write code here
            trace(arr, 1, arr[0]);
            return flag;
        }


        void trace(int[] arr, int index, int sum) {
            if (flag) return;
            if (index == arr.length) {
                if (sum == 24) {
                    flag = true;
                }
                return;
            }

            trace(arr, index + 1, sum + arr[index]);
            trace(arr, index + 1, sum - arr[index]);
            trace(arr, index + 1, sum * arr[index]);
            if (arr[index] != 0) {
                trace(arr, index + 1, sum / arr[index]);
            }
        }

        /**
         * @param s string字符串
         * @return bool布尔型
         */
        public boolean IsValidExp(String s) {
            // write code here
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('(', -1);
            map.put(')', 1);
            map.put('[', -2);
            map.put(']', 2);
            map.put('{', -3);
            map.put('}', 3);

            LinkedList<Character> stack = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty()) {
                    if (map.get(stack.peek()) + map.get(c) == 0) stack.pop();
                    else stack.push(c);
                } else stack.push(c);
            }
            return stack.size() == 0;
        }

        public int GetCoinCount(int N) {
            // write code here
            N = 1024 - N;

            int[] dp = new int[N + 1];

            int[] coins = {1, 4, 16, 64};

            for (int coin : coins) {
                for (int i = 1; i <= N; i++) {
                    dp[i] = i - coin < 0 ? dp[i] : dp[i - coin] + 1;
                }
            }
            return dp[N];
        }
    }
}


