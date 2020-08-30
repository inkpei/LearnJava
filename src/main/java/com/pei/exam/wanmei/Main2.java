package com.pei.exam.wanmei;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {


    static long[] minWay = new long[6];
    static int[][] weight = new int[6][];
    ;
    static boolean[] flag = new boolean[6];


    public static void main(String[] args) {
        Arrays.fill(minWay, Integer.MAX_VALUE);
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            String[] valuesStr = input.nextLine().split(" ");
            int[] values = new int[valuesStr.length];
            for (int j = 0; j < valuesStr.length; j++) {
                values[j] = Integer.parseInt(valuesStr[j]);
            }
            weight[i] = values;
        }
        input.close();

        trace(0, 0);
        for (int i = 1; i < 6; i++) {
            System.out.println(minWay[i] == Integer.MAX_VALUE ? -1 : minWay[i]);
        }
    }


    static void trace(int index, long sum) {
        if (index >= 6) return;
        minWay[index] = Math.min(minWay[index], sum);

        for (int i = 0; i < 6; i++) {
            if (i != index && weight[index][i] != -1 && !flag[i]) {
                flag[i] = true;
                trace(i, sum + weight[index][i]);
                flag[i] = false;
            }
        }
    }
}

/*

0 1 -1 -1 -1 -1
-1 0 -1 3 -1 -1
12 9 0 -1 5 -1
-1 -1 4 0 13 15
-1 -1 -1 -1 0 4
-1 -1 -1 -1 -1 0

 */
