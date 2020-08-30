package com.pei.exam.gbit;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal[] base = new BigDecimal[3];
        for (int i = 0; i < 3; i++) {
            base[i] = new BigDecimal(String.valueOf(scanner.nextLong()));
        }
        long n = scanner.nextLong();
        BigDecimal[][] produce = new BigDecimal[3][2];
        for (int i = 0; i < 3; i++) {
            produce[i][0] = new BigDecimal(String.valueOf(scanner.nextLong()));
            produce[i][1] = new BigDecimal(String.valueOf(scanner.nextLong()));
        }

        for (long i = 1; i <= n; i++) {
            BigDecimal[] next = new BigDecimal[3];
            System.arraycopy(base, 0, next, 0, 3);
            next[0] = next[0].add(base[1].multiply(produce[1][0]).add(base[2].multiply(produce[2][0])));
            next[1] = next[1].add(base[0].multiply(produce[0][0]).add(base[2].multiply(produce[2][1])));
            next[2] = next[2].add(base[0].multiply(produce[0][1]).add(base[1].multiply(produce[1][1])));
            base = next;

        }
        System.out.println(Arrays.stream(base).map(bigDecimal -> bigDecimal.divideAndRemainder(new BigDecimal("1000000007"))[1].toString()).collect(Collectors.joining(" ")));
    }


}

/*

100 10000 100000 10000
100 100
100 100
1000 100


 */
