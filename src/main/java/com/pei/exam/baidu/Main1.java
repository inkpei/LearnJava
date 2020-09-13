package com.pei.exam.baidu;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        int[] other = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            other[i] = sum - arr[i];
            if (other[i] > other[max]) max = i;
        }

        if (M > 1) {
            System.out.println(M * other[max] - arr[max]);
        } else {

        }

    }

}
