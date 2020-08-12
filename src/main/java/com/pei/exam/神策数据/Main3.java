package com.pei.exam.神策数据;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] arr = new String[N];

        arr[0] = "1";
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < N; i++) {
            String s1 = get(arr[a], "3");
            String s2 = get(arr[b], "5");
            String s3 = get(arr[c], "11");
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(s1);
            tmp.add(s2);
            tmp.add(s3);
            tmp.sort((aa, j) -> aa.length() == j.length() ? aa.compareTo(j) : aa.length() - j.length());
            String min = tmp.get(0);
            if (min.equals(s1)) a++;
            if (min.equals(s2)) b++;
            if (min.equals(s3)) c++;
            arr[i] = min;
        }
        System.out.println(arr[N - 1]);
    }

    static String get(String a, String b) {
        return new BigDecimal(a).multiply(new BigDecimal(b)).toString();
    }
}
