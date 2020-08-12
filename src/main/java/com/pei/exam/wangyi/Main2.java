package com.pei.exam.wangyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int p = 0; p < total; p++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int ans = 0;
            char[][] arr = new char[m][n];
            scanner.nextLine();
            for (int j = 0; j < m; j++) {
                arr[j] = scanner.nextLine().toCharArray();
            }


            HashMap<Character, Pair> map = new HashMap<>();
            Pair cur = new Pair();
            // 查找宝藏位置
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
//                    System.out.println(arr[i][j]);
                    if (arr[i][j] >= '0' && arr[i][j] <= '9') {
                        map.put(arr[i][j], new Pair(i, j));
                    }
                    if (arr[i][j] == '*') {
                        cur.x = i;
                        cur.y = j;
                    }
                }
            }

            while (map.size() > 0) {
                char nextWea = getRecent(map, cur.x, cur.y);
                int tmp = find(arr, cur.x, cur.y, map.get(nextWea).x, map.get(nextWea).y);
                if (tmp == -1) {
                    ans = -1;
                    break;
                } else {
                    ans += tmp;
                    cur = map.get(nextWea);
                    map.remove(nextWea);
                }
            }
            list.add(ans);
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    static int find(char[][] arr, int i, int j, int ii, int jj) {
        if (i == ii && j == jj) return 0;
        int distance = getDistance(i, j, ii, jj);
        if (i > 0) {
            if (arr[i - 1][j] != '#') {
                int up = getDistance(i - 1, j, ii, jj);
                if (up < distance) {
                    int i1 = find(arr, i - 1, j, ii, jj);
                    if (i1 == -1) return -1;
                    else return 1 + i1;
                }
            }
        }

        if (i < arr.length - 1) {
            if (arr[i + 1][j] != '#') {
                int down = getDistance(i + 1, j, ii, jj);
                if (down < distance) {
                    int i1 = find(arr, i + 1, j, ii, jj);
                    if (i1 == -1) return -1;
                    else return 1 + i1;
                }
            }
        }

        if (j > 0) {
            if (arr[i][j - 1] != '#') {
                int left = getDistance(i, j - 1, ii, jj);
                if (left < distance) {
                    int i1 = find(arr, i, j - 1, ii, jj);
                    if (i1 == -1) return -1;
                    else return 1 + i1;
                }
            }
        }
        if (j < arr[0].length - 1) {
            if (arr[i][j + 1] != '#') {
                int right = getDistance(i, j + 1, ii, jj);
                if (right < distance) {
                    int i1 = find(arr, i, j + 1, ii, jj);
                    if (i1 == -1) return -1;
                    else return 1 + i1;
                }
            }
        }
        return -1;
    }

    static char getRecent(HashMap<Character, Pair> map, int i, int j) {
        int min = Integer.MAX_VALUE;
        char ans = '9';
        for (Character key : map.keySet()) {
            Pair value = map.get(key);
            int distance = getDistance(i, j, value.x, value.y);
            if (distance < min || (distance == min && key < ans)) {
                ans = key;
                min = distance;
            }
        }
        return ans;
    }

    static int getDistance(int i, int j, int ii, int jj) {
        return Math.abs(i - ii) + Math.abs(j - jj);
    }

    static class Pair {
        int x;
        int y;

        public Pair() {
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}



/*
3
5 5
0...1
.#.#.
..*..
##.#.
2...3
5 5
0...1
.#.#.
..*.#
.#.#.
2.#.3
5 5
.....
.#.#.
..*..
.###.
0....




 */
