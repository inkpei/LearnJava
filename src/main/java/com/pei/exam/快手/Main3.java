package com.pei.exam.快手;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int T = scanner.nextInt();
        int[][] A = new int[N][2];
        int[][] B = new int[M][2];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            A[i] = new int[]{scanner.nextInt(), scanner.nextInt()};
            if (T <= A[i][1]) min = Math.min(min, A[i][0]);
        }

        for (int i = 0; i < M; i++) {
            B[i] = new int[]{scanner.nextInt(), scanner.nextInt()};
            if (T <= B[i][1]) min = Math.min(min, B[i][0]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int w = A[i][0] + B[j][0];
                int b = A[i][1] + B[j][1];
                if (b >= T) {
                    min = Math.min(min, w);
                }
            }
        }

        if (T == 0) {
            System.out.println(0);
        }
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
}
/*
2 1 4
3 1
2 1
1 2

 */
