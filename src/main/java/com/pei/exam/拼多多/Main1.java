package com.pei.exam.拼多多;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    arr[i][j] = 0;
                } else if (n % 2 == 1 && (i == n / 2 || j == n / 2)) {

                } else {
                    if (j >= n / 2) {
                        if (i < n / 2) {
                            if (i + j < n - 1) {
                                arr[i][j] = 1;
                            } else {
                                arr[i][j] = 8;
                            }
                        } else {
                            if (i < j) {
                                arr[i][j] = 7;
                            } else {
                                arr[i][j] = 6;
                            }
                        }
                    } else {
                        if (i < n / 2) {
                            if (i < j) {
                                arr[i][j] = 2;
                            } else {
                                arr[i][j] = 3;
                            }
                        } else {
                            if (i + j < n - 1) {
                                arr[i][j] = 4;
                            } else {
                                arr[i][j] = 5;
                            }
                        }
                    }
                }
            }
        }
        for (int[] ints : arr) {
            System.out.println(Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
