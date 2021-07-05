package com.ujiuye.sort;

/**
 * @author whx
 * @date 2021/6/26 0026 16:30
 */
public class Insertion extends Sort{
    @Override
    public int[] sort(int[] arr) {
        int value;
        int index;
        for (int i = 1; i < arr.length; i++) {
            value = arr[i];
            index = i - 1;
            while (index >= 0 && value < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            if(index != i - 1) {
                count++;
                arr[index + 1] = value;
            }
        }
        System.out.println(count + "次");
        return arr;
    }

    @Override
    public String getClassName() {
        return "插入";
    }
}
