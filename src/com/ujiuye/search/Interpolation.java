package com.ujiuye.search;

import java.util.ArrayList;

/**
 * @author whx
 * @date 2021/7/4 0004 13:54
 */
public class Interpolation extends Search{
    @Override
    public ArrayList<Integer> search(int[] arr, int value) {
        return orderSearch(arr,0,arr.length - 1,value);
    }

    public ArrayList<Integer> orderSearch(int[] arr,int left,int right,int value) {
        if(left > right || value > arr[right] || value < arr[left]) {
            return new ArrayList<>();
        }
        if(arr[right] == arr[left]) {
            if (value != arr[left]) {
                return new ArrayList<>();
            }else {
                ArrayList<Integer> resIndexList = new ArrayList<>();
                int temp = left;
                while (temp <= right) {
                    resIndexList.add(temp);
                    temp++;
                }
                return resIndexList;
            }
        }
        int mid = (int) (left + (long)(right - left) * (long) (value - arr[left]) / (arr[right] - arr[left]));

        if (arr[mid] == value) {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == value) {
                resIndexList.add(temp);
                temp--;
            }

            resIndexList.add(mid);

            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == value) {
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }else if(arr[mid] > value) {
            return orderSearch(arr,left,mid - 1,value);
        }else {
            return orderSearch(arr,mid + 1,right,value);
        }
    }

    @Override
    public String getClassName() {
        return "插值";
    }
}
