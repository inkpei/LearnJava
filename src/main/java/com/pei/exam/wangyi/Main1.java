package com.pei.exam.wangyi;

public class Main1 {

    public static void main(String[] args) {
        Main1 main1 = new Main1();
        int dis = main1.getDis(new int[]{10, 5}, 2);
        System.out.println(dis);

    }


    public int getDis(int[] A, int n) {
        int max = 0;
        int flag = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] < flag) {
                flag = A[i];
            }
            max = Math.max(0, A[i] - flag);
        }
        return max;
    }


    public int[][] flipChess(int[][] A, int[][] f) {
        // write code here

        for (int[] ints : f) {
            int a = ints[0] - 1;
            int b = ints[1] - 1;

            if (a > 0) {
                A[a - 1][b] = 1 - A[a - 1][b];
            }

            if (a < A.length - 1) {
                A[a + 1][b] = 1 - A[a + 1][b];
            }

            if (b > 0) {
                A[a][b - 1] = 1 - A[a][b - 1];
            }

            if (b < A[0].length - 1) {
                A[a][b + 1] = 1 - A[a][b + 1];
            }
        }
        return A;
    }
}
