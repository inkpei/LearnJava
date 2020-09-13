package com.pei.exam.拼多多;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    int cur = dfs(arr, i, j, index);
                    map.put(index++, cur);
                }
            }
        }
        long max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    if (i > 0 && arr[i - 1][j] != 0) {
                        set.add(-arr[i - 1][j]);
                    }
                    if (i < arr.length - 1 && arr[i + 1][j] != 0) {
                        set.add(-arr[i + 1][j]);
                    }

                    if (j > 0 && arr[i][j - 1] != 0) {
                        set.add(-arr[i][j - 1]);
                    }
                    if (j < arr[0].length - 1 && arr[i][j + 1] != 0) {
                        set.add(-arr[i][j + 1]);
                    }
                    long ans = 0;
                    for (Integer s : set) {
                        ans += map.get(s);

                    }
                    if (map.size() != set.size()) ans++;
                    max = Math.max(ans, max);
                }
            }
        }
        System.out.println(max);
    }

    static int dfs(int[][] arr, int i, int j, int k) {
        if (arr[i][j] <= 0) return 0;
        int ans = 1;
        arr[i][j] = -k;
        if (i > 0) {
            ans += dfs(arr, i - 1, j, k);
        }
        if (i < arr.length - 1) {
            ans += dfs(arr, i + 1, j, k);
        }

        if (j > 0) {
            ans += dfs(arr, i, j - 1, k);
        }
        if (j < arr[0].length - 1) {
            ans += dfs(arr, i, j + 1, k);
        }

        return ans;
    }

}
