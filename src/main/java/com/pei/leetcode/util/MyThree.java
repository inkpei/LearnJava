package com.pei.leetcode.util;

import java.util.LinkedList;

public class MyThree {


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
}
