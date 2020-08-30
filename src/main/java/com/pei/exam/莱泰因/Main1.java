package com.pei.exam.莱泰因;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        if (s.length < 2) {
            System.out.println(-1);
        } else if (s[1].equals("")) {
            System.out.println(0);
        } else System.out.println(s[0].indexOf(s[1]));
    }
}
