package com.pei.exam.aiqixin;

import java.util.Scanner;

public class Main1 {


    static int[] flag;
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int begin = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        flag = new int[N];

        for (int i = 0; i < N; i++) {
            flag[i] = i;
        }
        trace(0, 0);
        System.out.println(min);
    }

    static void trace(int index, int cost) {
        if (index == arr.length) {
//            System.out.println(Arrays.toString(flag));
            cost += arr[flag[flag.length - 1]][flag[0]];
            min = Math.min(cost, min);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(flag, index, i);
            if (index > 0) cost += arr[flag[index]][flag[index - 1]];
            trace(index + 1, cost);
            swap(flag, index, i);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
