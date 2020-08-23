package com.pei.exam.老虎;

import com.pei.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class Main1 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> res = solution.combinationSum(new int[]{
                3, 8, 6
        }, 14);
        for (ArrayList<Integer> re : res) {
            System.out.println(re);
        }

    }


}

class Solution {
    /**
     * 排队
     *
     * @param head ListNode类 头结点
     * @return ListNode类
     */
    public ListNode lineUp(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        ListNode p = head.next;
        int stp = 0;
        while (p != null) {
            if (stp == 0) {
                ListNode tmp = p.next;
                if (tmp == null) break;

                p.next = tmp.next;
                tmp.next = tail.next;
                tail.next = tmp;
                tail = tmp;
                stp = 1;
            }
            stp--;
            p = p.next;
        }
        return head;
    }

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    int[] prices;

    public ArrayList<ArrayList<Integer>> combinationSum(int[] prices, int m) {
        this.prices = prices;
        trace(new ArrayList<>(), m, 0);
        return ans;
    }

    void trace(ArrayList<Integer> cur, int k, int index) {
        if (k == 0) {
            ArrayList<Integer> tmp = new ArrayList<>(cur);
            Collections.sort(tmp);
            ans.add(tmp);
            return;
        } else if (k < 0) {
            return;
        }
        for (int i = index; i < prices.length; i++) {

            cur.add(prices[i]);
            trace(cur, k - prices[i], i + 1);
            cur.remove(cur.size() - 1);


        }


    }


}
