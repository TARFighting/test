package com.ujiuye.linkedlist;

/**
 * @author whx
 * @date 2021/6/9 0009 21:33
 */
public class Test3 {
    public static void main(String[] args) {
        CircleLinkedList cll = new CircleLinkedList();
        int num;
        cll.add(new TheHero(0,"赵"));
        cll.add(new TheHero(1,"钱"));
        cll.add(new TheHero(2,"孙"));
        cll.add(new TheHero(3,"李"));
        cll.add(new TheHero(4,"周"));
        cll.add(new TheHero(5,"吴"));
        cll.add(new TheHero(6,"郑"));
        cll.add(new TheHero(7,"王"));
        cll.list();
        System.out.println();
        cll.remove(new TheHero(0,"赵"));
        cll.list();
        System.out.println();
        while ((num = cll.remove(2)) != -1) {
            System.out.println(num);
        }
    }

    //判断回文数(闲来无事做的leetcode的题)
    public static boolean isPan(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reserveX = 0;
        while (x > reserveX) {
            reserveX = reserveX * 10 + x % 10;
            x = x / 10;
        }
        return reserveX == x || x == reserveX / 10;
    }
}
