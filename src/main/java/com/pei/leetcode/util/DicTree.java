package com.pei.leetcode.util;

//字典树(前缀树)的实现(添加、删除、查找、查找前缀)
public class DicTree {
    public TrieNode root; //定义根节点

    //字典树构造函数初始化
    public DicTree() {
        root = new TrieNode();
    }

    //字典树节点的定义
    class TrieNode {

        public int path;
        public int end;
        public TrieNode[] map;

        //构造函数实现初始化
        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }

    }

    //(1)添加
    public void insert(String word) {
        if (word == null) {
            return;
        }
        //字符串转数组
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (char ch : chs) {
            index = ch - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            node = node.map[index];
            node.path++;
        }
        node.end++;
    }

    //(2)删除
    public void delete(String word) {
        //字典树中是否含有word单词
        if (search(word)) {
            //字符串转数组
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (char ch : chs) {
                index = ch - 'a';
                if (node.map[index].path-- == 1) {
                    node.map[index] = null;
                    return;
                }
                node = node.map[index];

            }
            node.end--;
        }
    }

    //(3)查找
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        //字符串转数组
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (char ch : chs) {
            index = ch - 'a';
            if (node.map[index] == null) {

                return false;
            }
            node = node.map[index];

        }
        return node.end != 0;
    }

    //(4)查找前缀
    public int PreSearch(String pre) {
        if (pre == null) {
            return 0;
        }

        char[] chs = pre.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (char ch : chs) {
            index = ch - 'a';
            if (node.map[index] == null) {
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }

    public static void main(String[] args) {
        //System.out.println("Hello");
        DicTree dicTree = new DicTree();
        String str1 = "abc";
        String str2 = "abcd";
        String str3 = "abd";
        String str4 = "b";
        String str5 = "bcd";
        String str6 = "efg";
        String str7 = "hik";

        dicTree.insert(str1);
        dicTree.insert(str2);
        dicTree.insert(str3);
        dicTree.insert(str4);
        dicTree.insert(str5);
        dicTree.insert(str6);
        dicTree.insert(str7);

        System.out.println(dicTree.search(str3));
        dicTree.delete(str3);
        System.out.println(dicTree.search(str3));

        System.out.println(dicTree.PreSearch(str3));
        System.out.println(dicTree.PreSearch(str1));


    }
}
