package com.pei.leetcode.util;

import java.util.Arrays;

public class Parse {

    public static String[] parseStrArr(String s) {
        s = s.replaceAll(" *", "");
        s = s.replaceAll("\\[", "");
        s = s.replaceAll("]", "");
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
        s = s.replaceAll("\\[", "");
        s = s.replaceAll("]", "");
        String[] split = s.split(",");
        return Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] parseIntArr2D(String s) {
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split("],\\[");
        int[][] ans = new int[split.length][];
        for (int i = 0; i < split.length; i++) {
            ans[i] = parseIntArr(split[i]);
        }
        print(ans);
        return ans;
    }

    public static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(int[][] arr) {
        for (int[] inits : arr) {
            System.out.println(Arrays.toString(inits));
        }
    }

    public static void print(String[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void print(String[][] arr) {
        for (String[] ins : arr) {
            System.out.println(Arrays.toString(ins));
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(parseStrArr2D("[ [\"a\", \"c\"], [\"b\", \"a\"], [\"a\", \"e\"], [\"a\", \"a\"], [\"x\", \"x\"] ]")));
    }
}
