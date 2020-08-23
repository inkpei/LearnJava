package com.pei.exam.爱奇艺;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', -1);
        map.put(')', 1);
        map.put('[', -2);
        map.put(']', 2);
        map.put('{', -3);
        map.put('}', 3);
        for (char c : s.toCharArray()) {
            Integer cur = map.get(c);
            if (cur < 0) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    stack.push(cur);
                    break;
                } else {
                    if (stack.peek() + cur == 0) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(stack.isEmpty() ? "True" : "False");
    }
}
