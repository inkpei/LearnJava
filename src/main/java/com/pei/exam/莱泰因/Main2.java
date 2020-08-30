package com.pei.exam.莱泰因;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        K = scanner.nextInt();
        trace(M, N, new StringBuilder());
        System.out.println(ans);
    }

    static long K;
    static String ans;
    static boolean flag = false;


    static void trace(int a, int b, StringBuilder cur) {
        if (flag) return;
        if (cur.length() > 0) {
            K--;
            if (K == 0) {
                ans = cur.toString();
                flag = true;
                return;
            }
        }
        if (a > 0) {
            cur.append('a');
            trace(a - 1, b, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (b > 0) {
            cur.append('b');
            trace(a, b - 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
