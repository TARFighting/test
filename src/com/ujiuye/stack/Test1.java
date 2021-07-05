package com.ujiuye.stack;

/**
 * @author whx
 * @date 2021/6/10 0010 21:26
 */
public class Test1 {
    public static void main(String[] args) {
        LinkedStack ls = new LinkedStack();
        ls.push(new TheHero(1,"赵"));
        ls.push(new TheHero(2,"钱"));
        ls.push(new TheHero(3,"孙"));
        ls.push(new TheHero(4,"李"));
        ls.push(new TheHero(5,"周"));
        ls.push(new TheHero(6,"吴"));
        ls.push(new TheHero(7,"郑"));
        ls.push(new TheHero(8,"王"));
        ls.list();
        System.out.println();
        System.out.println(ls.pop());
        System.out.println(ls.pop());
        System.out.println(ls.pop());
        System.out.println(ls.pop());
        System.out.println();
        ls.push(new TheHero(5,"周"));
        ls.push(new TheHero(6,"王"));
        ls.list();
    }
}
