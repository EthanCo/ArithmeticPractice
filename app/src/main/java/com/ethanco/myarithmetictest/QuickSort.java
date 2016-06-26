package com.ethanco.myarithmetictest;

/**
 * 快速排序
 * Created by EthanCo on 2016/6/26.
 */
public class QuickSort {

    static int[] arr = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

    public static void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left; //左哨兵
        int j = right; //右哨兵
        int refer; //基位数,参照数
        int t; //临时
        refer = arr[left];



        while (i != j) {
            while (arr[j] >= refer && i < j) {
                j--;
            }

            while (arr[i] <= refer && i < j) {
                i++;
            }

            if (i < j) { //当哨兵i和哨兵i没有相遇时
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        //最终将基位数归位
        t = arr[i];
        arr[i] = arr[left];
        arr[left] = t;

        //递归处理
        quickSort(left, i - 1); //继续处理基位数左边
        quickSort(i + 1, right); //继续处理基位数右边
    }

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        quickSort(0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
