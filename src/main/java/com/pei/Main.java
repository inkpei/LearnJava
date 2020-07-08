package com.pei;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));


    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int read = 0;
        int write = 0;
        int target = nums[0];
        int count = 0;
        while (read < nums.length) {
            if (nums[read] == nums[write]) count++;
            else {
                target = nums[read];
                count = 1;
            }
            if (count >= 3) write--;
            nums[write] = nums[read];
            read++;
            write++;
        }
        System.out.println(Arrays.toString(nums));
        return write;
    }
}
