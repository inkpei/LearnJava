package com.pei.leetcode.util;

import java.util.HashMap;

public class MoveWindow {

    //https://leetcode-cn.com/problems/minimum-window-substring/
    // 最小覆盖串
    public String minWindow(String s, String t) {
        // 存储约束条件
        HashMap<Character, Integer> need = new HashMap<>();
        // 存储当前窗口状态
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        // 标记结果
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 窗口右移
            right++;
            // 更新窗口状态
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 已经满足条件, 尝试缩小窗口
            while (valid == need.size()) {

                // 更新结果
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // 缩小窗口
                char d = s.charAt(left);
                left++;

                // 更新窗口信息
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }

            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
