package com.pei.exam.kedaxunfei;

import java.util.ArrayList;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        String[] arr = s.split(" ");

        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || c == '+' || c == '-') {
                builder.append(c);
            }
        }
        System.out.println(Integer.parseInt(builder.toString()));

    }
}
