package com.ujiuye.linkedlist;

/**
 * @author whx
 * @date 2021/6/7 0007 20:22
 */
public class SingletonList {
    //链表的头节点不存放数据,就只是一个链表头而已
    private TheHero head = new TheHero(0,"");

    public TheHero getHead() {
        return head;
    }

    public void remove(TheHero th) {
        TheHero temp = head.getNext();
        while (true) {
            if (temp == null) {
                System.out.println("不存在此数据,无法删除");
                break;
            }else if(temp.getNext().getNo() == th.getNo()) {
                temp.setNext(temp.getNext().getNext());
                break;
            }else {
                temp = temp.getNext();
            }
        }
    }

    public void set(TheHero th) {
        TheHero temp = head.getNext();
        while (true) {
            if (temp == null) {
                System.out.println("不存在此数据,无法修改");
                break;
            }else if(temp.getNext().getNo() == th.getNo()) {
                th.setNext(temp.getNext().getNext());
                temp.setNext(th);
                break;
            }else {
                temp = temp.getNext();
            }
        }
    }

    public void addByNo(TheHero th) {
        //创建一个临时变量temp存储链表数据
        TheHero temp = head;
        //遍历链表寻找符合No顺序的合适的插入位置
        while (true) {
            //当temp的地址区为null,说明链表已到结尾,将数据直接插入尾部即可
            if (temp.getNext() == null) {
                temp.setNext(th);
                break;
            }else {
                //按照No从大到小的顺序进行比较,当找到合适的位置时,插入数据
                if (temp.getNext().getNo() >= th.getNo()) {
                    //把temp后一节点的地址放在即将插入的数据的地址区
                    th.setNext(temp.getNext());
                    //把temp的地址区的地址指向插入的数据即可
                    temp.setNext(th);
                    break;
                }else {
                    temp = temp.getNext();
                }
            }
        }
    }

    public void add(TheHero th) {
        TheHero temp = head;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(th);
                break;
            }else {
                temp = temp.getNext();
            }
        }
    }

    public void list() {
        //遍历链表时先将头节点的地址区地址传给一个临时变量temp,然后开始遍历
        TheHero temp = head.getNext();
        if (temp.getNext() == null) {
            System.out.println("链表为空");
        }else {
            while (true) {
                if (temp == null) {
                    break;
                }else {
                    System.out.println(temp);
                    temp = temp.getNext();
                }
            }
        }
    }
}
