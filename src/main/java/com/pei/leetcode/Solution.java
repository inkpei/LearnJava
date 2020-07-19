package com.pei.leetcode;

import com.pei.leetcode.util.ListNode;

/**
 * @Project: LearnJdkCode
 * @Author: Pei
 * @Description:
 * @Data: 2020/6/22
 */

public
class Solution {
    public int kthToLast(ListNode head, int k) {
        if (head == null) return 0;
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        while (p != null) {
            head = head.next;
            p = p.next;
        }
        return head.val;
    }
}
