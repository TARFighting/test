package com.ujiuye.search;

import com.ujiuye.sort.Radix;

import java.util.*;

/**
 * @author whx
 * @date 2021/7/3 0003 16:33
 */
public class Test {
    static int count = 800000;
    static int value = new Random().nextInt(count);

    public static void main(String[] args) {
        List<Integer> list = random();
        ArrayList<Integer> resIndexList = orderSearch(list,new Liner(),null);

        orderSearch(list,new Binary(),resIndexList);

        orderSearch(list,new Interpolation(),resIndexList);

        orderSearch(list,new Fibonacci(),resIndexList);
    }

    public static ArrayList<Integer> orderSearch(List<Integer>list, Search search, ArrayList<Integer> index) {
        int[] arr = new Radix().sort(list.stream().mapToInt(Integer::valueOf).toArray());
        //System.out.println(Arrays.toString(arr) + "  " + value);
        return searchValue(arr,search,value,index);
    }

    private static ArrayList<Integer> searchValue(int[] temp, Search search, int value, ArrayList<Integer> index0) {
        long begin = System.currentTimeMillis();
        ArrayList<Integer> indexList = search.search(temp,value);
        long end = System.currentTimeMillis();
        System.out.println(search.getClassName() + (end - begin) + "毫秒");
        if(indexList.size() == 0) {
            System.out.println("未找到该值");
        }
        if (index0 != null) {
            Collections.sort(indexList);
            Collections.sort(index0);
            System.out.println((indexList.toString().equals(index0.toString())));
        }
        System.out.println();
        return indexList;
    }

    public static List<Integer> random() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(new Random().nextInt(count) + 1);
        }
        return list;
    }
}
