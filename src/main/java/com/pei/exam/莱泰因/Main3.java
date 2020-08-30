package com.pei.exam.莱泰因;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt() - 1;
        int b = scanner.nextInt() - 1;
        int c = scanner.nextInt() - 1;
        int year = scanner.nextInt();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "1");

        String pre = "1";
        for (int i = 2; i <= year; i++) {
            String breath = "0";
            String dead = "0";
            if (i - a > 0) {
                breath = add(breath, map.get(i - a));
            }
            if (i - b > 0) {
                breath = add(breath, map.get(i - b));
            }
            if (i - c > 0) {
                dead = map.remove(i - c);
            }
            map.put(i, breath);
            pre = add(pre, add(breath, "-" + dead));
        }

        System.out.println(pre);
    }

    static String add(String a, String b) {
        return new BigDecimal(a).add(new BigDecimal(b)).toString();
    }
}

/*

有一只羊
在第二年会生一只羊
在第四年会生一只羊
在第五年死去

现在求第15年总共有多少羊

对应的输入是:
2 4 5 15
输出
318

 */
