package com.pei.leetcode.util;

import java.util.HashMap;


// https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/208-shi-xian-trie-qian-zhui-shu-bao-gua-insert-sea/
public class Trie {
    public class TrieNode {
        public int path;
        public int end;
        public HashMap<Character, TrieNode> next;

        public TrieNode() {
            // 表示当前节点所能链接到其他节点的个数（在删除操作中会用到）
            path = 0;
            // 表示以当前节点为结尾的单词的个数
            end = 0;
            // 表示当前节点能链接到的所有节点。
            next = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.equals("")) return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) {
                node.next.put(ch, new TrieNode());
            }
            node = node.next.get(ch);
            node.path++;
        }
        node.end++;
    }

    public boolean search(String word) {
        if (word == null || word.equals("")) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) return false;
            node = node.next.get(ch);
        }
        return node.end != 0;
    }

    public boolean startsWith(String word) {
        if (word == null || word.equals("")) return false;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.next.containsKey(ch)) return false;
            node = node.next.get(ch);
        }
        return true;
    }

    public void delete(String word) {
        if (word == null || word.equals("") || !search(word)) return;
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (--node.next.get(ch).path == 0) {
                node.next.remove(ch);
                return;
            }
            node = node.next.get(ch);
        }
        node.end--;
    }

}
