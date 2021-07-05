package com.ujiuye.search;

import java.util.ArrayList;

/**
 * @author whx
 * @date 2021/7/4 0004 12:02
 */
public class Binary extends Search{
    @Override
    public ArrayList<Integer> search(int[] arr, int value) {
        return orderSearch(arr,0,arr.length - 1,value);
    }

    public ArrayList<Integer> orderSearch(int[] arr,int left,int right,int value) {
        int mid = (left + right)/ 2;
        if(left > right || value > arr[arr.length - 1] || value < arr[0]) {
            return new ArrayList<>();
        }
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
        return "二分";
    }
}
