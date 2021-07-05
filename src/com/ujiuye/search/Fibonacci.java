package com.ujiuye.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author whx
 * @date 2021/7/4 0004 16:15
 */
public class Fibonacci extends Search{
    @Override
    public ArrayList<Integer> search(int[] arr, int value) {
        ArrayList<Integer> resIndexList = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        int k = 0;
        int[] fib = fib(arr.length);

        while (right > fib[k]) {
            k++;
        }

        int[] temp = Arrays.copyOf(arr,fib[k]);
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        while (left <= right) {
            mid = left + fib[k - 1] - 1;
            if (temp[mid] > value) {
                right = mid - 1;
                k--;
            }else if(temp[mid] < value) {
                left = mid + 1;
                k -= 2;
            }else {
                if(mid < right) {
                    return findAllValue(resIndexList,arr,mid,value);
                }else {
                    return findAllValue(resIndexList,arr,right,value);
                }
            }
        }

        return resIndexList;
    }

    private ArrayList<Integer> findAllValue(ArrayList<Integer> resIndexList,int[] arr,int index,int value) {
        int temp = index - 1;
        while (temp >= 0 && arr[temp] == value) {
            resIndexList.add(temp);
            temp--;
        }

        resIndexList.add(index);

        temp = index + 1;
        while (temp <= arr.length - 1 && arr[temp] == value) {
            resIndexList.add(temp);
            temp++;
        }

        return resIndexList;
    }

    private int[] fib(int maxSize) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        while (maxSize > list.get(list.size() - 1)) {
            list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    @Override
    public String getClassName() {
        return "斐波那契";
    }
}
