package com.pei.exam.京东;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();
        long[][] arr = new long[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToLong(Integer::parseInt).toArray();
        }
        long max = arr[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                long a = 0;
                long b = 0;
                long c = 0;
                if (j - 2 >= 0 && j - 2 < arr[i - 1].length) {
                    a = arr[i - 1][j - 2];
                }
                if (j - 1 >= 0 && j - 1 < arr[i - 1].length) {
                    b = arr[i - 1][j - 1];
                }
                if (j < arr[i - 1].length) {
                    c = arr[i - 1][j];
                }

                arr[i][j] += Math.max(a, Math.max(b, c));
                max = Math.max(arr[i][j], max);
            }
        }
        for (long[] longs : arr) {
            System.out.println(Arrays.toString(longs));
        }
        System.out.println(max);
    }
}
