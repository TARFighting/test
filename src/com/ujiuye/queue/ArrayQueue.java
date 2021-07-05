package com.ujiuye.queue;

import java.util.Arrays;

/**
 * @author whx
 * @date 2021/6/5 0005 15:04
 */
public class ArrayQueue {
    //font代表数组的第一个数值存放位的前一个位置
    private int font = -1;
    //maxSize代表数组最后一个数值存放位
    private int rear = -1;
    private int maxSize;
    private  int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有数据");
        }else {
            return arr[font + 1];
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有数据");
        }else {
            return arr[++font];
        }
    }

    public void addQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满,无法添加数据");
        }else {
            arr[++rear] = num;
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
        }else {
            System.out.println(Arrays.toString(arr));
        }
    }

    public boolean isEmpty() {
        return font == rear;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }
}
