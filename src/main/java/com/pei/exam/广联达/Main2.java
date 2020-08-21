package com.pei.exam.广联达;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int sum = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sum();
            System.out.println(sum / 8 * 4);
        }

    }


}
