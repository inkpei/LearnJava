package com.pei.leetcode;


public
class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int a = 0;
        int b = 0;
        long preA = 0;
        long preB = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        while (a < len1 && b < len2) {
            if (nums1[a] == nums2[b]) {
                preA = (Math.max(preA, preB) + nums1[a]);
                preB = preA;
                a++;
                b++;
            } else if (nums1[a] < nums2[b]) {
                preA = (preA + nums1[a++]);
            } else {
                preB = (preB + nums2[b++]);
            }
        }
        while (a < len1) {
            preA = (preA + nums1[a++]);
        }
        while (b < len2) {
            preB = (preB + nums2[b++]);
        }
        return (int) ((Math.max(preA, preB)) % 1000000007);
    }


    public int maxSum1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        long mode = 1000000000 + 7;
        long pre1 = 0;
        long pre2 = 0;
        int i1 = 1, i2 = 1;
        for (; i1 <= n1 && i2 <= n2; ) {
            if (nums1[i1 - 1] < nums2[i2 - 1]) {
                pre1 = pre1 + nums1[i1 - 1];
                i1++;
            } else if (nums1[i1 - 1] > nums2[i2 - 1]) {
                pre2 = pre2 + nums2[i2 - 1];
                i2++;
            } else if (nums1[i1 - 1] == nums2[i2 - 1]) {
                long max = Math.max(pre1 + nums1[i1 - 1], pre2 + nums2[i2 - 1]);
                pre1 = max;
                pre2 = max;
                i1++;
                i2++;
            }
        }
        for (; i1 <= n1; i1++) pre1 = pre1 + nums1[i1 - 1];
        for (; i2 <= n2; i2++) pre2 = pre2 + nums2[i2 - 1];
        return (int) (Math.max(pre1, pre2) % mode);
    }
}
