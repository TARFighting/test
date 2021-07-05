package com.ujiuye.sort;

/**
 * @author whx
 * @date 2021/6/24 0024 21:19
 */
public class Selection extends Sort{
    @Override
    public int[] sort(int[] arr) {
        int min;
        int minIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min) {
                    minIndex = j;
                    min = arr[minIndex];
                    count++;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(count + "次");
        return arr;
    }

    @Override
    public String getClassName() {
        return "选择";
    }
}
