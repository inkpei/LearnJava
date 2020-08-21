package com.pei.exam.滴滴;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[][] arr = new long[N][N];
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(1L);
        while (list.size() < N * N) {
            list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
        }
        int index = list.size() - 1;
        int len = N - 1;
        int a = 0;
        int b = 0;
        while (len >= 0) {
            index = get(arr, a++, b++, len, index, list);
            len -= 2;
        }
        for (long[] ints : arr) {
            System.out.println(Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
    }

    static int get(long[][] arr, int i, int j, int len, int index, ArrayList<Long> list) {
        if (len == 0) {
            arr[i][j] = list.get(index);
            return 0;
        }

        //向右
        for (int k = 0; k < len; k++) {
            arr[i][j + k] = list.get(index--);
        }
        //向下
        for (int k = 0; k < len; k++) {
            arr[i + k][j + len] = list.get(index--);
        }
        //向左
        for (int k = 0; k < len; k++) {
            arr[i + len][j + len - k] = list.get(index--);
        }
        //向上

        for (int k = 0; k < len; k++) {
            arr[i + len - k][j] = list.get(index--);
        }
        return index;
    }
}
