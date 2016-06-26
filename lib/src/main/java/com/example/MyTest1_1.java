package com.example;

/**
 * 桶排序
 * Created by EthanCo on 2016/5/28.
 */
public class MyTest1_1 {
    public void main(String[] args) {
        int[] arr = new int[]{5, 3, 5, 2, 8};
        int[] book = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int index = arr.length;
            book[index] += 1;
        }

        for (int i = 0; i < book.length; i++) {
            for (int j = 0; j < book[i]; j++) {
                System.out.println(String.valueOf(i));
            }
        }
    }
}
