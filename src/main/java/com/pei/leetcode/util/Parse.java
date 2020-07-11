package com.pei.leetcode.util;

import java.util.Arrays;

public class Parse {

    public static String[] parseStrArr(String s) {
        s = s.replaceAll(" *", "");
        s = s.replaceAll("\\[", "");
        s = s.replaceAll("\\]", "");
        s = s.replaceAll("\"", "");
        return s.split(",");
    }

    public static String[][] parseStrArr2D(String s) {
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split("\\], \\[");
        String[][] ans = new String[split.length][];
        for (int i = 0; i < split.length; i++) {
            ans[i] = parseStrArr(split[i]);
        }
        return ans;
    }

    public static int[] parseIntArr(String s) {
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split(",");
        return Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] parseIntArr2D(String s) {
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split(",");
        int[][] ans = new int[split.length][];
        for (int i = 0; i < split.length; i++) {
            ans[i] = parseIntArr(split[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(parseStrArr2D("[ [\"a\", \"c\"], [\"b\", \"a\"], [\"a\", \"e\"], [\"a\", \"a\"], [\"x\", \"x\"] ]")));
    }
}
