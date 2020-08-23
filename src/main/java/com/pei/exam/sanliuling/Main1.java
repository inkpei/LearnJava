package com.pei.exam.sanliuling;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            if (s.length() <= 10 && s.length() > 0) {
                boolean flag = true;
                for (int j = 0; j < s.length(); j++) {
                    s = s.toLowerCase();
                    if (s.charAt(j) < 'a' || s.charAt(j) > 'z') {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans++;
            }

        }

        System.out.println(ans);

    }
}
