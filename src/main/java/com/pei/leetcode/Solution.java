package com.pei.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        K = k;
        N = n;
        trace(new HashSet<>(), 0);
        return new ArrayList<>(ans);
    }

    int K;
    int N;
    HashSet<List<Integer>> ans = new HashSet<>();

    void trace(HashSet<Integer> set, int sum) {
        if (set.size() == K) {
            if (sum == N) {
                ArrayList<Integer> list = new ArrayList<>(set);
                Collections.sort(list);
                ans.add(list);
            }
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (!set.contains(i)) {
                set.add(i);
                trace(set, sum + i);
                set.remove(i);
            }
        }
    }
}
