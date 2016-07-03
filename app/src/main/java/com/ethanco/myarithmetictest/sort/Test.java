package com.ethanco.myarithmetictest.sort;

/**
 * Created by EthanCo on 2016/6/26.
 */
public class Test {
    public static void main(String[] args) {
        //int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int[] arr = new int[]{6, 1, 2, 7, 9, 9, 5, 6, 5, 3, 4, 5, 10, 8};
        //ISort sortPart = new SortUtil();
        ISort sortPart = new SortReview();
        sortPart.quickSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
