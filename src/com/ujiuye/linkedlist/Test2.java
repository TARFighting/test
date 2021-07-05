package com.ujiuye.linkedlist;

/**
 * @author whx
 * @date 2021/6/9 0009 20:11
 */
public class Test2 {
    public static void main(String[] args) {
        DoubleLinkedList dsl = new DoubleLinkedList();
        //普通添加数据
        dsl.add(new TheHero(1,"赵"));
        dsl.add(new TheHero(2,"钱"));
        dsl.add(new TheHero(3,"孙"));
        dsl.add(new TheHero(4,"李"));
        dsl.add(new TheHero(5,"周"));
        //遍历链表
        dsl.list();
        System.out.println();
        //按No大小顺序添加数据
        dsl.addByNo(new TheHero(5,"吴"));
        dsl.addByNo(new TheHero(0,"王"));
        dsl.list();
        System.out.println();
        dsl.set(new TheHero(1,"周"));
        dsl.list();
        System.out.println();
        //System.out.println(getLength(dsl));
        dsl.remove(new TheHero(5,"吴"));
        dsl.remove(new TheHero(5,"周"));
        dsl.list();
        /*System.out.println(getLength(dsl));
        System.out.println(findLastIndex(dsl,4));
        System.out.println(findLastIndex(dsl,0));
        reserves(dsl);*/
        //dsl.list();
    }
}
