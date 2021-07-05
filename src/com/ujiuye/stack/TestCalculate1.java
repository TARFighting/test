package com.ujiuye.stack;

/**
 * @author whx
 * @date 2021/6/15 0015 21:06
 */
public class TestCalculate1 {
    public static void main(String[] args) {
        String expression = "6-4*(4+3)-7";
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack charStack = new ArrayStack(10);
        for (int i = 0; i < expression.length(); i++) {
            if (isCharacter(expression.charAt(i))) {
                if (charStack.top != -1 && expression.charAt(i) != '(' && priority(expression.charAt(i)) <= priority((char) charStack.top())) {
                    calculate(numStack,charStack);
                }
                if (charStack.top != -1 && expression.charAt(i) != '(' && priority(expression.charAt(i)) <= priority((char) charStack.top())) {
                    calculate(numStack,charStack);
                }
                charStack.add(expression.charAt(i));
            }else {
                if (charStack.top != -1 && charStack.top() == 45) {
                    numStack.add(48 - expression.charAt(i));
                    charStack.remove();
                    charStack.add('+');
                }else {
                    addNum(numStack,expression,i);
                }
            }
        }

        while (charStack.top != -1) {
            calculate(numStack,charStack);
        }

        System.out.println(numStack.top());
    }

    public static void addNum(ArrayStack as,String s,int index) {
        if (index > 0 && !isCharacter(s.charAt(index - 1))) {
            int x = as.remove();
            if (x > 0) {
                as.add(x * 10 + (s.charAt(index) - 48));
            }else {
                as.add(x * 10 - (s.charAt(index) - 48));
            }
        }else {
            as.add(s.charAt(index) - 48);
        }
    }

    public static char calculate(ArrayStack numStack, ArrayStack charStack) {
        int num1 = numStack.remove();
        int num2 = numStack.remove();
        char ch = (char) charStack.remove();
        if (ch == '(') {
            numStack.add(num2);
            numStack.add(num1);
            return ch;
        }
        result(num1,num2,ch,numStack,charStack);
        return ch;
    }

    public static void result(int num1,int num2,char ch,ArrayStack as,ArrayStack asc) {
        int res = 0;
        switch (ch) {
            case '+' :
                res = num1 + num2;
                break;
            case '-' :
                res = num2 - num1;
                break;
            case '*' :
                res = num1 * num2;
                break;
            case '/' :
                res = num2 / num1;
                break;
            case ')' :
                as.add(num2);
                as.add(num1);
                while (true) {
                    if (calculate(as,asc) == '(') {
                        break;
                    }
                }
                return;
            default:
                break;
        }
        as.add(res);
    }

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

    public static boolean isCharacter(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '(' || ch == ')';
    }
}
