package com.pei.exam.kedaxunfei;

import java.util.Scanner;

public class Main1 {
    static int[][] arr = new int[5][2];
    ;
    static int min = Integer.MAX_VALUE;

    //    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        arr[0][0] = 1;
        arr[1][0] = 5;
        arr[2][0] = 10;
        arr[3][0] = 50;
        arr[4][0] = 100;
        for (int i = 0; i < 5; i++) {
            arr[i][1] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        if (target < 0) {
            System.out.println(0);
            return;
        }

        trace(0, target);
        min = min == Integer.MAX_VALUE ? 0 : min;
        System.out.println(min);
    }

    static void trace(int count, int target) {
        if (target < 0) return;
        if (target == 0) {
            min = Math.min(min, count);
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i][1] > 0 && arr[i][0] <= target) {
                arr[i][1] -= 1;
                trace(count + 1, target - arr[i][0]);
                arr[i][1] += 1;
            }
        }
    }
}
/*

10 5 0 0 3
155
 */
