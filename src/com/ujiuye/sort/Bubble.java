package com.ujiuye.sort;

/**
 * @author whx
 * @date 2021/6/24 0024 20:50
 */
public class Bubble extends Sort{
    @Override
    public int[] sort(int[] arr) {
        boolean flag = true;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                    count++;
                }
            }
            if (flag) {
                break;
            }
            flag = true;
        }
        System.out.println(count + "次");
        return arr;
    }

    @Override
    public String getClassName() {
        return "冒泡";
    }
}
