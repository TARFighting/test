package com.ujiuye.sort;

/**
 * @author whx
 * @date 2021/7/3 0003 15:56
 */
public class Radix extends Sort{
    @Override
    public int[] sort(int[] arr) {
        int max = arr[0];
        for (int j : arr) {
            if (max < j) {
                max = j;
            }
        }
        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketLength = new int[10];
        int temp;
        int index;
        for (int i = 0,n = 1; i < maxLength; i++,n *= 10) {
            index = 0;
            for (int j = 0; j < arr.length; j++) {
                temp = arr[j] / n % 10;
                bucket[temp][bucketLength[temp]] = arr[j];
                bucketLength[temp]++;
            }

            for (int j = 0; j < bucket.length; j++) {
                for (int k = 0; k < bucketLength[j]; k++) {
                    arr[index] = bucket[j][k];
                    index++;
                }
                bucketLength[j] = 0;
            }
        }

        return arr;
    }

    @Override
    public String getClassName() {
        return "基数";
    }
}
