package com.pei.leetcode;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description:
 * @Data: 2020/6/22
 */

public
class Solution {
    public int rob(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int pre = nums[0];
        int now = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int tmp = now;
            now = Math.max(now, pre + nums[i]);
            pre = tmp;
        }

        return now;

    }
}
