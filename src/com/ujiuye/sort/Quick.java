package com.ujiuye.sort;

/**
 * @author whx
 * @date 2021/7/2 0002 21:01
 */
public class Quick extends Sort{
    @Override
    public int[] sort(int[] arr) {
        quick(arr,0,arr.length - 1);
        return arr;
    }

    public void quick(int[] arr,int left,int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right)/2];
        while (l < r) {
            int temp;
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if(l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot && arr[r] == pivot) {
                r--;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (l < right) {
            quick(arr,l,right);
        }
        if (r > left) {
            quick(arr,left,r);
        }
    }

    @Override
    public String getClassName() {
        return "快排";
    }
}
