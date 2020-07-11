package com.pei.leetcode.util;


import java.util.Deque;
import java.util.LinkedList;

// 最小栈
class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            if (x <= min.peek()) min.push(x);
        }
    }

    public void pop() {
        Integer pop = stack.pop();
        if (min.peek().equals(pop)) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
