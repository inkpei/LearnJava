package com.pei.exam.sanliuling;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = i + 1;
        }
        for (int i = 0; i < M; i++) {
            int k = scanner.nextInt();
            if (k == 1) {
                get1(ans);
            } else {
                get2(ans);
            }
        }
        System.out.println(Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

    }

    static void get1(int[] arr) {
        int tmp = arr[0];
        System.arraycopy(arr, 1, arr, 0, arr.length - 1);
        arr[arr.length - 1] = tmp;
    }

    static void get2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i += 2) {
            swap(arr, i, i + 1);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
