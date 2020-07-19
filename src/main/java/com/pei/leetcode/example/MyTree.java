package com.pei.leetcode.example;

import com.pei.leetcode.util.TreeNode;

import java.util.*;


// 常用树操作
public class MyTree {


    // 层序遍历
    public void levelTraverse(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int pre = 1;
        int count = 0;

        while (queue.size() != 0) {
            TreeNode node = queue.removeFirst();
            pre--;

            if (node.left != null) {

                queue.addLast(node.left);
                count++;
            }

            if (node.right != null) {

                queue.addLast(node.right);
                count++;
            }
            // 当前层便利完毕
            if (pre == 0) {

                pre = count;
                count = 0;

            }
        }

    }

    // 前序非递归

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ans;
    }

    // 中序非递归
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode p = root;

        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode pop = stack.pop();
            ans.add(pop.val);
            if (pop.right != null) {
                p = pop.right;
            }
        }
        return ans;
    }


    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }
        Collections.reverse(ans);
        return ans;
    }
}
