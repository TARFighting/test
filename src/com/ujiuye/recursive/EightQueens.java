package com.ujiuye.recursive;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author whx
 * @date 2021/6/19 0019 15:07
 */
public class EightQueens {
    private int[] board;
    private int count = 0;

    public static void main(String[] args) {
        EightQueens eq = new EightQueens(8);
        eq.answer();
    }

    public EightQueens(int max) {
        board = new int[max];
    }

    public void answer() {
        location(0);
        System.out.println("共有" + count + "种解法");
    }

    private void location(int x) {
        if(x == board.length) {
            print();
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[x] = i;
            if (judge(x)) {
                location(x + 1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if(board[i] == board[n] || Math.abs(n - i) == Math.abs(board[n] - board[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        System.out.println(Arrays.toString(board));
        count++;
    }
}
