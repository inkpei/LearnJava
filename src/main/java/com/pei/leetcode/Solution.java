package com.pei.leetcode;


import java.util.LinkedList;

public
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> stack = new LinkedList<>();
        put(stack, newInterval);
        for (int[] interval : intervals) {
            put(stack, interval);
        }
        int[][] ans = new int[stack.size()][2];
        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.get(stack.size() - 1 - i);
        }
        return ans;
    }

    void put(LinkedList<int[]> stack, int[] cur) {

        if (stack.isEmpty()) {
            stack.push(cur);
        } else {
            int[] peek = stack.peek();
            if (cur[0] > peek[1]) {
                stack.push(cur);
            } else if (cur[1] < peek[0]) {
                int[] pop = stack.pop();
                put(stack, cur);
                stack.push(pop);
            } else {
                int[] pop = stack.pop();
                int[] tmp = {
                        Math.min(pop[0], cur[0]), Math.max(pop[1], cur[1])
                };
                put(stack, tmp);
            }
        }
    }
}
