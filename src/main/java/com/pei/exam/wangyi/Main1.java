package com.pei.exam.wangyi;

import java.util.HashMap;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int maxId = 0;
        int TimeMax = 0;
        for (int i = 0; i < total; i++) {
            int N = scanner.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < N; j++) {
                int time = scanner.nextInt();
                int id = scanner.nextInt();
                int flag = scanner.nextInt();
                if (flag == 0) {
                    map.put(id, time);
                } else {

                    if (time - map.get(id) > TimeMax) {
                        TimeMax = time - map.get(id);
                        maxId = id;
                    }
                }
            }
            System.out.println(maxId);

        }
    }
}


class Pair {
    int time;
    int id;

    public Pair(int time, int id) {
        this.time = time;
        this.id = id;
    }
}

/*
2
8
1 10 0
5 2 0
10 3 0
20 3 1
25 4 0
40 4 1
1000 2 1
2000 10 1
8
1 10 0
5 2 0
10 3 0
20 3 1
25 4 0
40 4 1
1000 2 1
2000 10 1



 */
