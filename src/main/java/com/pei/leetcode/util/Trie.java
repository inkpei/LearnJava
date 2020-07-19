package com.pei.leetcode.util;

// https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/208-shi-xian-trie-qian-zhui-shu-bao-gua-insert-sea/
public class Trie {

    Node Head;

    public Trie() {
        Head = new Node();
    }


    public void insert(String word) {
        Node p = Head;
        for (char c : word.toCharArray()) {
            if (p.arr[c - 'a'] == null) {
                p.arr[c - 'a'] = new Node();
                p.arr[c - 'a'].c = c;
            }
            p = p.arr[c - 'a'];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        Node p = Head;
        for (char c : word.toCharArray()) {
            if (p.arr[c - 'a'] == null) return false;
            p = p.arr[c - 'a'];
        }
        return p.isEnd;
    }


    public boolean startsWith(String prefix) {
        Node p = Head;
        for (char c : prefix.toCharArray()) {
            if (p.arr[c - 'a'] == null) return false;
            p = p.arr[c - 'a'];
        }
        return true;
    }

    class Node {
        Node[] arr = new Node[26];
        char c;
        boolean isEnd = false;
    }
}
