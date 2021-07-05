package com.ujiuye.stack;

/**
 * @author whx
 * @date 2021/6/10 0010 20:38
 */
public class LinkedStack {
    private TheHero head = new TheHero(0,"");
    private TheHero rear = null;

    public LinkedStack() {
    }

    public void push(TheHero th) {
        TheHero temp = head;
        while (true) {
            if(temp.getNext() == null) {
                temp.setNext(th);
                break;
            }else {
                temp = temp.getNext();
            }
        }
    }

    public TheHero pop() {
        if (head.getNext() == null) {
            return null;
        }else {
            TheHero temp = head.getNext();
            while (true) {
                if (temp.getNext().getNext() == null) {
                    TheHero th = temp.getNext();
                    temp.setNext(null);
                    return th;
                }else {
                    temp = temp.getNext();
                }
            }
        }
    }

    public void list() {
        if (head.getNext() == null) {
            System.out.println("栈是空的");
        }else {
            TheHero temp = head;
            while (true) {
                if (temp.getNext().getNext() == rear) {
                    System.out.println(rear = temp.getNext());
                    if (rear == head.getNext()) {
                        break;
                    }else {
                        list();
                        rear = null;
                        break;
                    }
                }else {
                    temp = temp.getNext();
                }
            }
        }
    }
}
