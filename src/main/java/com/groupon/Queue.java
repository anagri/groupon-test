package com.groupon;

public class Queue {
    private int head = 0, tail = 0;
    private final int[] values;

    public Queue(int size) {
        values = new int[size];
    }

    public Queue enqueue(int value) {
        synchronized (values) {
            values[tail] = value;
            tail = incrementAndMod(tail);
        }
        return this;
    }

    public int dequeue() {
        int value;
        synchronized (values) {
            value = values[head];
            head = incrementAndMod(head);
        }
        return value;
    }

    private int incrementAndMod(int value) {
        return (value + 1) % values.length;
    }
}
