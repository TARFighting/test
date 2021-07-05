package com.ujiuye.stack;

/**
 * @author whx
 * @date 2021/6/10 0010 20:24
 */
public class Test {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(5);
        as.add(0);
        as.add(1);
        as.add(2);
        as.add(3);
        as.add(4);
        as.show();
        System.out.println();
        System.out.println(as.remove());
        System.out.println();
        as.add(99);
        System.out.println(as.remove());
        System.out.println(7.1+0.01);
    }
}
