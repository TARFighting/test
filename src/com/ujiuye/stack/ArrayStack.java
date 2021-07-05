package com.ujiuye.stack;

import java.util.Arrays;

/**
 * @author whx
 * @date 2021/6/10 0010 20:11
 */
public class ArrayStack {
    public int top = -1;
    private int maxSize;
    private int[] arr;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public void add(int x) {
        if(isFull()) {
            throw new RuntimeException("栈已满");
        }else {
            arr[++top] = x;
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("栈中无数据");
        }else {
            return arr[top--];
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("栈中无数据");
        }else {
            for (int i = top; i >= 0 ; i--) {
                System.out.println(arr[i]);
            }
        }
    }

    public int top() {
        return arr[top];
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == this.maxSize - 1;
    }
}
