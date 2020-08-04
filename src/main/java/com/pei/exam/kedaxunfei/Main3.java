package com.pei.exam.kedaxunfei;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[4][2];
        for (int i = 0; i < 4; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        int res = 0;
        if (judge(arr[0][0], arr[1][0], arr[2][0], arr[3][0]) && judge(arr[0][1], arr[1][1], arr[2][1], arr[3][1]))
            res = 1;
        System.out.println(res);

    }

    static boolean judge(int ax, int ay, int bx, int by) {
        int[] a = get(ax, ay);
        int[] b = get(bx, by);
        return (b[0] <= a[1] && b[1] >= a[0]);
    }

    static int[] get(int a, int b) {
        int[] res = new int[2];
        res[0] = Math.min(a, b);
        res[1] = Math.max(a, b);
        return res;
    }
}
