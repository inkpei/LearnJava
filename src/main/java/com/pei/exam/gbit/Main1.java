package com.pei.exam.gbit;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        String str = s[0].toLowerCase();
        String a = s[1].toLowerCase();
        String b = s[2].toLowerCase();
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a.charAt(0)) {
                listA.add(i);
            }
            if (str.charAt(i) == b.charAt(0)) {
                listB.add(i);
            }
        }

        if (listA.size() == 0 || listB.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(Math.max(Math.abs(listA.get(0) - listB.get(listB.size() - 1)), Math.abs(listA.get(listA.size() - 1) - listB.get(0))));
        }
    }
}
