package com.ujiuye.queue;

import java.util.Scanner;

/**
 * @author whx
 * @date 2021/6/5 0005 15:17
 */
public class Test {
    public static void main(String[] args) {
        //非环形队列
        ArrayQueue aq = new ArrayQueue(3);
        //环形队列
        CircleArrayQueue caq = new CircleArrayQueue(3);
        //自己写的整体下移队列,可以达到和环形队列相同的效果,个人认为可能效率比环形队列低(存疑)
        myArrayQueue maq = new myArrayQueue(3);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 ------ 查看队列里的数据");
            System.out.println("2 ------ 往队列里添加数据");
            System.out.println("3 ------ 从队列中取出数据");
            System.out.println("4 ------ 查看队列的头数据");
            System.out.println("5 ------ 退出");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //查看队列里的数据
                    //aq.show();
                    //caq.show();
                    maq.show();
                    break;
                case 2:
                    //往队列里添加数据
                    System.out.println("请输入一个数据：");
                    int num = sc.nextInt();
                    try {
                        //aq.addQueue(num);
                        //caq.addQueue(num);
                        maq.addQueue(num);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    //从队列中取出数据
                    try {
                        //System.out.println(aq.getQueue());
                        //System.out.println(caq.getQueue());
                        System.out.println(maq.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    //查看队列的头数据
                    try {
                        //System.out.println(aq.headQueue());
                        //System.out.println(caq.headQueue());
                        System.out.println(maq.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    //退出程序
                    System.out.println("程序已退出");
                    return;
                default:
                    break;
            }
        }
    }
}
