package com.ujiuye.queue;

import java.util.Arrays;

/**
 * @author whx
 * @date 2021/6/5 0005 16:19
 */
public class CircleArrayQueue {
    //font代表数组的第一个数值存放位
    private int font = 0;
    //rear代表数组最后一个数值存放位+1
    private int rear = 0;
    //maxSize代表数组大小
    private final int maxSize;
    private final int[] arr;

    public CircleArrayQueue(int maxSize) {
        //这种环形队列实际上存在一个无法利用的空位,所以提前留出一个空位
        this.maxSize = maxSize + 1;
        this.arr = new int[this.maxSize];
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有数据");
        }else {
            return arr[font];
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有数据");
        }else {
            int num = arr[font];
            font = (font + 1) % maxSize;
            return num;
        }
    }

    public void addQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满,无法添加数据");
        }else {
            arr[rear] = num;
            rear = (rear + 1) % maxSize;
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
        }else {
            for (int i = font; i < font + arraySize(); i++) {
                System.out.print(arr[i % maxSize] + " ");
            }
            System.out.println();
        }
    }

    private int arraySize() {
        return (rear + maxSize - font) % maxSize;
    }

    public boolean isEmpty() {
        return font == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == font;
    }
}
