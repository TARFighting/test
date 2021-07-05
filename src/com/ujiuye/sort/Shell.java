package com.ujiuye.sort;

/**
 * @author whx
 * @date 2021/6/29 0029 20:46
 */
public class Shell extends Sort{
    @Override
    public int[] sort(int[] arr) {
        int temp;
        int index;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                if(arr[i] < arr[i - gap]) {
                    temp = arr[i];
                    index = i;
                    while (index - gap >= 0 && temp < arr[index - gap]) {
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }
                    if(index != i) {
                        count++;
                        arr[index] = temp;
                    }
                }
            }
        }
        System.out.println(count + "次");
        return arr;
    }

    @Override
    public String getClassName() {
        return "希尔";
    }
}
