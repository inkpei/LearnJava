package com.pei.exam.alibaba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] arr = new int[N - 1];

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        for (int i = 0; i < N - 1; i++) {
            map.put(i + 2, scanner.nextInt());
        }

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            ArrayList<Integer> listA = get(map, a);
            ArrayList<Integer> listB = get(map, b);
            if (listA.size() <= listB.size()) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }

    static ArrayList<Integer> get(HashMap<Integer, Integer> map, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        while (target != 0) {
            Integer parent = map.get(target);
            list.add(parent);
            target = parent;
        }
        return list;
    }


}
