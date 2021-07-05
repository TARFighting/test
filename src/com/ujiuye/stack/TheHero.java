package com.ujiuye.stack;

/**
 * @author whx
 * @date 2021/6/7 0007 20:20
 */
public class TheHero {
    //前两项属性为链表节点的实际数据区
    private int no;
    private String name;
    //next为链表节点的地址区,指向链表的下一个节点
    private TheHero next;
    //pre为链表节点的地址区,指向链表的前一个节点
    private TheHero pre;

    public TheHero(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "no= " + no + ", name='" + name;
    }

    public int getNo() {
        return no;
    }

    public TheHero getPre() {
        return pre;
    }

    public void setPre(TheHero pre) {
        this.pre = pre;
    }

    public TheHero getNext() {
        return next;
    }

    public void setNext(TheHero next) {
        this.next = next;
    }
}
