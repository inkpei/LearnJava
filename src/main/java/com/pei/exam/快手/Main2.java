package com.pei.exam.快手;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {

    static int ans = 0;
    static char[][] chars = new char[6][6];
    static ArrayList<int[]> list = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            String s = scanner.nextLine();
            chars[i] = s.toCharArray();
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (chars[i][j] == '#') {
                    list.add(new int[]{i, j});
                }
            }
        }
        trace(0);
        if (ans >= 1000000009) ans %= 1000000009;
        System.out.println(ans);
    }

    static void trace(int index) {
        if (index >= list.size()) {
            if (ans >= 1000000009) ans %= 1000000009;
            ans++;
            return;
        }
        int i = list.get(index)[0];
        int j = list.get(index)[1];
        for (int k = 0; k < 6; k++) {
            if (judge(i, j, k)) {
                chars[i][j] = (char) (k + '0');
                trace(index + 1);
            }
        }
        chars[i][j] = '#';
    }

    static boolean judge(int i, int j, int t) {
        if (i > 0) if (chars[i - 1][j] == t + '0') return false;
        if (i < 5) if (chars[i + 1][j] == t + '0') return false;
        if (j > 0) if (chars[i][j - 1] == t + '0') return false;
        if (i < 5) if (chars[i][j + 1] == t + '0') return false;
        return true;
    }

}
/*

##****
******
******
******
******
******

###***
******
******
******
******
******

##****
##****
******
******
******
******

 */
