package com.pei.exam.aiqixin;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main1 {





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i - 1]) {
                int j = 0;
                while (arr[j] < arr[i]) j++;
                int tmp = arr[i];
                if (i - j >= 0) System.arraycopy(arr, j, arr, j + 1, i - j);
                arr[j] = tmp;
                System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
            }
        }
    }

}
