package com.pei.exam.vivo;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int start_0 = scanner.nextInt();
        int start_1 = scanner.nextInt();
        end_0 = scanner.nextInt();
        end_1 = scanner.nextInt();
        scanner.nextLine();
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            arr[i] = s.replace("@", "#").toCharArray();
        }
        trace(start_0, start_1, 0);
        System.out.println(ans);
    }

    static char[][] arr;
    static int ans = Integer.MAX_VALUE;
    static int end_0;
    static int end_1;

    public static void trace(int i, int j, int k) {
//        System.out.println(i + " " + j + " " + k);
        if (i == end_0 && j == end_1) {
            ans = Math.min(ans, k);
            return;
        }
        char tmp = arr[i][j];
        arr[i][j] = '#';
        if (i > 0 && arr[i - 1][j] != '#') {

            trace(i - 1, j, k + 1);

        }
        if (i < arr.length - 1 && arr[i + 1][j] != '#') {

            trace(i + 1, j, k + 1);

        }

        if (j > 0 && arr[i][j - 1] != '#') {

            trace(i, j - 1, k + 1);

        }
        if (j < arr.length - 1 && arr[i][j + 1] != '#') {

            trace(i, j + 1, k + 1);

        }

    }
}
