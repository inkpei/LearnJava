package com.pei.exam.wangyi;

import java.util.HashMap;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int val = Integer.parseInt(s1[0]);
            Node node = map.get(val);
            if (node == null) {
                node = new Node();
                map.put(val, node);
            }
            if (s1[1].equals("left")) {
                node.left = Integer.parseInt(s1[2]);
                node.count++;
            } else {
                node.right = Integer.parseInt(s1[2]);
                node.count++;
            }
        }
        int ans = 0;
        for (Node value : map.values()) {
            if (value.count == 2) {
                if (map.get(value.left) == null && map.get(value.right) == null) ans++;
            }
        }
        System.out.println(ans);
    }

    static class Node {
        int left;
        int right;
        int count = 0;
    }
}

/*

10 9
1 left 2
1 right 3
2 left 4
2 right 5
3 right 6
6 left 7
6 right 8
7 left 9
7 right 10

 */
