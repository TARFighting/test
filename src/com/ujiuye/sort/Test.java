package com.ujiuye.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author whx
 * @date 2021/6/24 0024 20:58
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = random();
        int[] arr0 = sort(list,new Bubble());

        sort(list,new Selection(),arr0);

        sort(list,new Insertion(),arr0);

        sort(list,new Shell(),arr0);

        sort(list,new Quick(),arr0);

        sort(list,new Merge(),arr0);

        sort(list,new Radix(),arr0);

    }

    public static int[] sort(List<Integer> list,Sort sort,int[]... arr2) {
        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        long l0 = System.currentTimeMillis();
        int[] arr1 = sort.sort(arr);
        long l1 = System.currentTimeMillis();
        //System.out.println(Arrays.toString(arr1));
        System.out.println(sort.getClassName() + (l1 - l0) + "毫秒");
        if (arr2.length != 0) {
            System.out.println(Arrays.equals(arr2[0],arr1));
        }
        System.out.println();
        return arr1;
    }

    public static List<Integer> random() {
        int count = 80000;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Random().nextInt(count) + 1);
        }
        return list;
    }
}
