package com.ujiuye.queue;

/**
 * @author whx
 * @date 2021/6/5 0005 19:51
 */
public class myArrayQueue {
    private int rear = 0;
    private int maxSize;
    private int[] arr;

    public myArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有数据");
        }else {
            return arr[0];
        }
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有数据");
        }else {
            int value = arr[0];
            moveDown();
            return value;
        }
    }

    public void addQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满,无法添加数据");
        }else {
            arr[rear++] = num;
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空,没有数据");
        }else {
            for (int i = 0; i < rear; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    private void moveDown() {
        if (rear > 1) {
            System.arraycopy(arr, 1, arr, 0, rear-- - 1);
        }else {
            rear = 0;
        }
    }

    public boolean isEmpty() {
        return rear == 0;
    }

    public boolean isFull() {
        return rear == maxSize;
    }

}
