package com.pei.exam.queue;

public class LinkedQueue<E> implements Queue<E> {
    Node head = null;
    Node tail = null;
    int size = 0;

    @Override
    public void push(E e) {
        Node node = new Node(e);
        if (tail == null) {
            head = node;
        } else {
            tail.next = node;
        }
        size++;
        tail = node;
    }

    @Override
    public E poll() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node tmp = head;
            head = null;
            tail = null;
            size--;
            return tmp.val;
        } else {
            Node tmp = head;
            head = head.next;
            size--;
            return tmp.val;
        }
    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        } else {
            return head.val;
        }
    }

    class Node {
        E val;
        Node next = null;

        public Node(E val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.push(6);
        System.out.println(queue.size);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.size);
    }
}

