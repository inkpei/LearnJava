package com.pei.exam.滴滴;

import java.util.HashSet;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == j) continue;
                for (int k = 0; k < 10; k++) {
                    if (k == i || k == j) continue;
                    int abc = i * 100 + j * 10 + k;
                    int acc = N - abc;
                    if (acc == i * 100 + k * 10 + k) {
                        set.add(abc);
                    }
                }
            }
        }

        System.out.println(set.size());
        for (Integer integer : set) {
            System.out.println(integer + " " + (N - integer));
        }
    }
}
