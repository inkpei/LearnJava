package com.pei.exam.爱奇艺;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int ans = 0;
        int p = 1;
        while (p * 5 < N) {
            int tmp = p;
            while (p % 5 == 0) {
                ans++;
                p /= 5;
            }
            p = tmp;
            ans++;
            p++;
        }
        System.out.println(ans);

    }
}
