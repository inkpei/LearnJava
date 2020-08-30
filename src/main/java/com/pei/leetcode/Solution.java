package com.pei.leetcode;


import java.util.HashSet;

public
class Solution {
    public String reduce(String s) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                ans.append(c);
                set.add(c);
            }
        }
        return ans.toString();
    }
}
