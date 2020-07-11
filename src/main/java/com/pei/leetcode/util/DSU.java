package com.pei.leetcode.util;

public
class DSU {

    int[] parent;

    public DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (x != parent[x])  // x不是自身的父亲，即x不是该集合的代表
            parent[x] = find(parent[x]);  // 查找x的祖先直到找到代表,于是顺手路径压缩
        return parent[x];
    }


    void union(int x, int y) {
        parent[find(x)] = find(y);  // 把 x 的祖先变成 y 的祖先的儿子
    }

    boolean isUnion(int x, int y) {
        return find(x) == find(y);
    }

}

