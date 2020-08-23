package com.pei.exam.爱奇艺;

import java.util.HashSet;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        boolean flag = true;
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int x = 0;
        int y = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            int tmp = x * 31 + y;
            if (set.contains(tmp)) {
                flag = false;
                break;
            }
            set.add(tmp);
        }
        if (flag) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
