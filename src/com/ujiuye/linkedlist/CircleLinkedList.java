package com.ujiuye.linkedlist;

/**
 * @author whx
 * @date 2021/6/9 0009 20:51
 */
public class CircleLinkedList {
    private TheHero first;

    public TheHero getFirst() {
        return first;
    }

    public int remove(int num) {
        int count = -1;
        if (first != null) {
            TheHero temp = first;
            for (int i = 1; i < num - 1; i++) {
                temp = temp.getNext();
            }
            count = temp.getNext().getNo();
            temp.setNext(temp.getNext().getNext());
            first = temp.getNext();
            if(temp == first) {
                first = null;
            }
        }
        return count;
    }

    public void remove(TheHero th) {
        if (first != null) {
            TheHero temp = first.getNext();
            if (temp == first && th == first) {
                first = null;
                return;
            }
            while (true) {
                if (temp.getNext() == first) {
                    if (th.getNo() == first.getNo()) {
                        temp.setNext(temp.getNext().getNext());
                        first = temp.getNext();
                        break;
                    }
                    break;
                }else if(temp.getNext().getNo() == th.getNo()) {
                    temp.setNext(temp.getNext().getNext());
                    break;
                }else {
                    temp = temp.getNext();
                }
            }
        }
    }

    public void add(TheHero th) {
        if (first == null) {
            first = th;
            th.setNext(th);
        }else {
            TheHero temp = first.getNext();
            while (true) {
                if (temp.getNext() == first) {
                    temp.setNext(th);
                    th.setNext(first);
                    break;
                }else {
                    temp = temp.getNext();
                }
            }
        }

    }

    public void list() {
        if (first != null) {
            System.out.println(first);
            TheHero temp = first.getNext();
            while (true) {
                if (temp == first) {
                    break;
                }else {
                    System.out.println(temp);
                    temp = temp.getNext();
                }
            }
        }
    }
}
