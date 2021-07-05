package com.ujiuye.search;

import java.util.ArrayList;

/**
 * @author whx
 * @date 2021/7/3 0003 16:34
 */
public abstract class Search {
    long count = 0L;

    public abstract ArrayList<Integer> search(int[] arr, int value);

    public abstract String getClassName();
}
