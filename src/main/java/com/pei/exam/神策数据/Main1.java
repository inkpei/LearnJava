package com.pei.exam.神策数据;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        LinkedList<Integer> stack = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') continue;
            if (c == '(') {
                stack.push(i);
            } else {
                list.add(new int[]{stack.pop(), i});
            }
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        System.out.println(list.size());
        for (int[] ints : list) {
            System.out.println(ints[0]);
            System.out.println(ints[1]);
        }
    }
}
