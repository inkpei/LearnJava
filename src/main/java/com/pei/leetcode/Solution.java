package com.pei.leetcode;


import java.util.HashSet;

public
class Solution {
    HashSet<Integer>[] map;
    int n;
    int count = 0;

    public int numWays(int n, int[][] relation, int k) {
        this.n = n;
        HashSet<Integer>[] hashSets = new HashSet[n];
        for (int[] ints : relation) {
            HashSet<Integer> tmp = hashSets[ints[0]];
            if (tmp == null) {
                tmp = new HashSet<>();
                hashSets[ints[0]] = tmp;
            }
            tmp.add(ints[1]);
        }
        map = hashSets;
        trace(0, k);
        return count;
    }

    void trace(int from, int k) {
        if (k == 0) {
            if (from == n - 1) {
                count++;
            }
            return;
        }

        HashSet<Integer> set = map[from];
        if (set == null) return;
        for (Integer integer : set) {
            trace(integer, k - 1);
        }
    }
}
