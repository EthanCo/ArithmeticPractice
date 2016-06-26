package com.ethanco.myarithmetictest;

/**
 * Created by EthanCo on 2016/6/26.
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        SortUtil sortPart = new SortUtil();
        sortPart.quickSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
