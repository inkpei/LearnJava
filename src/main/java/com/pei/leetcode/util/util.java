package com.pei.leetcode.util;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class util {

    public TreeNode traversal(TreeNode root) {
        // null or left
        if (root == null) {
            // do something and return;
        }

        // Divide 问题分解
        TreeNode left = traversal(root.left);
        TreeNode right = traversal(root.right);

        // Conquer 问题合并
        TreeNode result = null;
//        TreeNode result = left + right;
        return result;
    }

    public ArrayList<ArrayList<Integer>> bfs(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = queue.poll();

                level.add(tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            result.add(level);
        }
        return result;

    }

    public int binarySearch(int[] nums, int target) {
        if (nums == null && nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }
}
