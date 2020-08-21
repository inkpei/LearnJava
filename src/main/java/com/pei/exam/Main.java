package com.pei.exam;

import java.util.*;

public class Main {
    static class Node {
        public Node(String id, String pid, String name) {
            this.id = id;
            this.pid = pid;
            this.name = name;
        }

        public String id;
        public String pid;
        public String name;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取行数n
        int n = Integer.parseInt(scanner.nextLine());
        List<Node> nodes = new ArrayList<>(n);
        HashMap<String, Node> map = new HashMap<>();

        // 获取n行数据并转换成Node
        for (int i = 0; i < n; i++) {
            String nodeStr = scanner.nextLine();
            Node node = toNode(nodeStr);
            nodes.add(node);
            map.put(node.id, node);
        }

        // 获取给定的两个点
        String[] input = scanner.nextLine().split(" ");        // ....后续计算
        String p = input[0];
        HashSet<String> set = new HashSet<>();
        while (!p.equals("null")) {
            set.add(map.get(p).name);
            p = map.get(p).pid;
        }
        p = input[1];
        boolean flag = false;
        while (!p.equals("null")) {
            String name = map.get(p).name;
            if (set.contains(name)) {
                if (!flag) flag = true;
                else set.remove(name);
            } else {
                set.add(name);
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        list.sort(String::compareTo);
        for (String s : list) {
            System.out.println(s);
        }


    }

    // 将输入的字符串转换成Node
    private static Node toNode(String nodeStr) {

        String[] arr = nodeStr.split(",");

        return new Node(arr[0], arr[1], arr[2]);
    }
}
