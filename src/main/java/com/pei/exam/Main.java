package com.pei.exam;


import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        map.put('x', 0);
        map.put('y', 0);
        map.put('z', 0);
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        int left = 0;
        int right = s.length() - 1;
        int max = s.length();
        if (!isDouble(map)) {
            while (left <= right) {

            }
        }

    }

    static boolean isDouble(HashMap<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value % 2 != 0) return false;
        }
        return true;
    }

}

/*

1 1 2 3 2 3 2 3 3 1 1 1 3 1


 */
