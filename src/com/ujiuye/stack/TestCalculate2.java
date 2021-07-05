package com.ujiuye.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Test calculate 2
 * 逆波兰计算器
 * @author whx
 * @date 2021 /6/17 0017 20:23
 */
public class TestCalculate2 {
    public static void main(String[] args) {
        String span = suffix("((1+3 )+\n(1*\r2 ))-(3+1 )*(\t( 1+3)+3)-117.1115");
        System.out.println("结果为 " + calculate(result(span)));
    }

    /**
     * Result array list
     * 将后缀表达式放入一个list集合中方便后续计算
     * @param span span
     * @return the array list
     */
    public static ArrayList<String> result(String span) {
        ArrayList<String> list = new ArrayList<>();
        String[] s = span.split(" ");
        Collections.addAll(list,s);
        return list;
    }

    /**
     * Calculate double
     * 计算后缀表达式结果
     * @param list list
     * @return the double
     */
    public static double calculate(ArrayList<String> list) {
        Stack<Double> as = new Stack<>();
        for (String s : list) {
            if (s.matches("\\d+(\\.\\d+)?")) {
                as.add(Double.parseDouble(s));
            }else {
                double num1 = as.pop();
                double num2 = as.pop();
                switch (s) {
                    case "+":
                        as.push(num2 + num1);
                        break;
                    case "-":
                        as.push(num2 - num1);
                        break;
                    case "*":
                        as.push(num2 * num1);
                        break;
                    case "/":
                        as.push(num2 / num1);
                        break;
                    default:
                        throw new RuntimeException("运算符有误");
                }
            }
        }
        return as.pop();
    }

    /**
     * Prefix string
     * 把用户输入的表达式整理为中缀表达式，可以去除空格等制表符
     * @param span span
     * @return the string
     */
    public static String prefix(String span) {
        String dest = "";
        if (span != null) {
            dest = Pattern.compile("\\s*|\t|\r|\n").matcher(span).replaceAll("");
        }
        return dest;
    }

    /**
     * Suffix string
     * 中缀表达式转化成后缀表达式
     * @param span span 原中缀表达式
     * @return the string 转化后的后缀表达式
     */
    public static String suffix(String span) {
        Stack<String> stChar = new Stack<>();
        Stack<String> stNum = new Stack<>();
        span = prefix(span);
        String str = "";
        for (int i = 0; i < span.length(); i++) {
            if (isCharacter(span.charAt(i))) {
                if(span.charAt(i) == ')') {
                    String temp;
                    while (!"(".equals(temp = stChar.pop())) {
                        stNum.push(temp);
                    }
                }else if (stChar.isEmpty() || span.charAt(i) == '(') {
                    stChar.push(span.charAt(i) + "");
                }else if (priority(span.charAt(i)) <= priority(stChar.peek().charAt(0))) {
                    while (priority(span.charAt(i)) <= priority(stChar.peek().charAt(0))) {
                        stNum.push(stChar.pop());
                        if (stChar.isEmpty()) break;
                    }
                    stChar.push(span.charAt(i) + "");
                }else {
                    stChar.push(span.charAt(i) + "");
                }
            }else {
                addNum(stNum,span,i);
            }
        }
        while (!stChar.isEmpty()) {
            stNum.push(stChar.pop());
        }
        for (String s : stNum) {
            str = str + s + " ";
        }
        return str.trim();
    }

    /**
     * Add num *
     * 向栈中添加数字(包括多位数，小数)
     * @param as    as
     * @param s     s
     * @param index index
     */
    public static void addNum(Stack<String> as,String s,int index) {
        if (index > 0 && !isCharacter(s.charAt(index - 1))) {
            String num = as.pop();
            if (s.charAt(index) == '.') {
                as.push(num + ".");
            }else {
                as.push(num + s.charAt(index));
            }
        }else {
            as.push((s.charAt(index) - 48) + "");
        }
    }

    /**
     * Priority int
     * 判断运算符优先级
     * @param ch ch
     * @return the int
     */
    public static int priority(char ch) {
        if (ch == '+' || ch == '-') {
            return 0;
        }else if(ch == '*' || ch == '/') {
            return 1;
        }else if(ch == ')') {
            return 2;
        }else {
            return -1;
        }
    }

    /**
     * Is character boolean
     * 判断表达式中的每个字符是否是运算符
     * @param ch ch
     * @return the boolean
     */
    public static boolean isCharacter(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')';
    }
}
