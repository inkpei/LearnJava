package com.pei.exam.神策数据;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        boolean flag = false;
        if (a.length() == b.length()) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    list.add(i);
                }
            }

            if (list.size() == 0) {
                HashSet<Character> set = new HashSet<>();
                for (int i = 0; i < a.length(); i++) {
                    if (set.contains(a.charAt(i))) {
                        flag = true;
                        break;
                    }
                    set.add(a.charAt(i));
                }
            } else if (list.size() == 2) {
                Integer i = list.get(0);
                Integer j = list.get(1);
                char[] chars = a.toCharArray();
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                flag = new String(chars).equals(b);
            }
        }
        System.out.println(flag);
    }
}

/*

aa
aa

 */
