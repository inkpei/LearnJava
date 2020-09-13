package com.pei.exam.vivo;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        index = s.length() / 2;
        get(s, 0, s.length());
        if (res) {
            System.out.println(index);
        } else {
            System.out.println("false");
        }

    }

    static boolean flag = false;
    static int index;
    static boolean res = false;

    public static boolean get(String s, int a, int b) {
        return true;

    }

    public static String compileSeq(String input) {
        // write code here
        int[] array = Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> list = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        while (set.size() < array.length) {
            if (array[i] == -1) {
                if (!set.contains(i)) list.add(i);

                set.add(i);
            }
            if (set.contains(array[i])) {
                array[i] = -1;
            }
            i++;
            if (i == array.length) i = 0;
        }
        StringJoiner joiner = new StringJoiner(",");
        for (Integer integer : list) {
            String s = String.valueOf(integer);
            joiner.add(s);
        }
        return joiner.toString();
    }
}

