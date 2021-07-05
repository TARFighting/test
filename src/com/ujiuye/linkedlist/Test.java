package com.ujiuye.linkedlist;

/**
 * @author whx
 * @date 2021/6/7 0007 20:30
 */
public class Test {
    public static void main(String[] args) {
        SingletonList sl = new SingletonList();
        //普通添加数据
        sl.add(new TheHero(1,"赵"));
        sl.add(new TheHero(2,"钱"));
        sl.add(new TheHero(3,"孙"));
        sl.add(new TheHero(4,"李"));
        sl.add(new TheHero(5,"周"));
        //按No大小顺序添加数据
        sl.addByNo(new TheHero(5,"吴"));
        sl.addByNo(new TheHero(0,"王"));
        //遍历链表
        sl.list();
        System.out.println();
        sl.set(new TheHero(1,"周"));
        sl.list();
        System.out.println();
        System.out.println(getLength(sl));
        sl.remove(new TheHero(5,"吴"));
        sl.remove(new TheHero(5,"周"));
        sl.list();
        System.out.println(getLength(sl));
        System.out.println(findLastIndex(sl,4));
        System.out.println(findLastIndex(sl,0));
        reserves(sl);
        sl.list();
    }

    public static void reserves(SingletonList sl) {
        //创建一个新的链表,用于暂时存放反转中的链表
        SingletonList ssl = new SingletonList();
        //声明一个临时变量,用于给新链表添加数据
        TheHero th;
        //声明一个临时变量,用于遍历旧链表
        TheHero temp = sl.getHead().getNext();
        while (true) {
            if (temp == null) {
                break;
            }else {
                //把temp中的数据传给th
                th = temp;
                //把temp的后一个节点的数据传给temp用于继续遍历过程
                temp = temp.getNext();
                //把新链表的第一个节点的地址传给th
                th.setNext(ssl.getHead().getNext());
                //将新链表头节点的地址区指向th
                ssl.getHead().setNext(th);
            }
        }
        //将旧链表头节点地址区的地址指向新链表的第一个节点,这样旧链表的所有有效节点就完成了反转
        sl.getHead().setNext(ssl.getHead().getNext());
    }

    public static TheHero findLastIndex(SingletonList sl,int index) {
        int size = getLength(sl);
        TheHero temp = sl.getHead().getNext();
        if (index > size || index < 0) {
            return null;
        }else {
            for (int i = 0; i < size - index; i++) {
                temp = temp.getNext();
            }
            return temp;
        }
    }

    public static int getLength(SingletonList sl) {
        TheHero temp = sl.getHead().getNext();
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }
}
