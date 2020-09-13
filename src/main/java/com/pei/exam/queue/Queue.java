package com.pei.exam.queue;

public interface Queue<E> {
    void push(E e);

    E poll();

    E peek();
}
