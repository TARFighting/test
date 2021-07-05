package com.ujiuye.search;

import java.util.ArrayList;

/**
 * @author whx
 * @date 2021/7/3 0003 17:04
 */
public class Liner extends Search{
    @Override
    public ArrayList<Integer> search(int[] arr, int value) {
        ArrayList<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                indexList.add(i);
            }
        }
        return indexList;
    }

    @Override
    public String getClassName() {
        return "线性";
    }
}
