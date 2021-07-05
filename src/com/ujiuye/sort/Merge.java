package com.ujiuye.sort;

/**
 * @author whx
 * @date 2021/7/3 0003 14:48
 */
public class Merge extends Sort{
    @Override
    public int[] sort(int[] arr) {
        int[] temp = new int[arr.length];

        cut(arr,0,arr.length - 1,temp);

        return arr;
    }

    public void cut(int[] arr,int left,int right,int[] temp) {
        if(left < right) {
            int mid = (left + right)/ 2;

            cut(arr,left,mid,temp);
            cut(arr,mid + 1,right,temp);

            merge(arr,left,mid,right,temp);
        }
    }

    public void merge(int[] arr,int left,int mid,int right,int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }

    @Override
    public String getClassName() {
        return "归并";
    }
}
