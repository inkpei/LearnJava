package com.pei.exam.快手;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        int back = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] == K) {
                K = 0;
                break;
            }
            if (arr[i] < K) {
                K -= arr[i];
            } else {
                K = arr[i] - K;
                back++;
            }
        }

        if (K == 0) {
            System.out.println("paradox");
        } else {
            System.out.println(K + " " + back);
        }
    }
}

/*
10 4
6 3 3 3

6 3
4 2 6


 */
