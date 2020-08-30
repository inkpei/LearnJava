package com.pei.exam.京东;


import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        String[] arr = {"2", "3", "5"};
        while (n > 0) {
            String head = list.removeFirst();
            for (String s : arr) {
                list.addLast(head + s);
                n--;
                if (n == 0) break;
            }
        }
        System.out.println(list.getLast());
    }

}
