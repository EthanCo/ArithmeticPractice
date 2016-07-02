package com.ethanco.myarithmetictest;

/**
 * 第1章 排序
 * Created by EthanCo on 2016/5/28.
 */
public class SortUtil implements IArithmetic {
    /**
     * 1.桶排序
     * 非常浪费空间
     */
    public void drumSort() {
        int[] arr = new int[]{5, 3, 5, 2, 8};
        int[] book = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            book[index] += 1;
        }

        for (int i = book.length; i > 0; i--) {
            for (int j = 0; j < book[i]; j++) {
                System.out.println("Z-" + String.valueOf(i));
            }
        }
    }

    /**
     * 2.冒泡排序
     * 时间复杂度大 - 效率低
     */
    public void bubbeSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 快速排序
     * 不浪费空间，速度比冒泡排序快
     */
    public void quickSort(int[] sortArr) {
        quickSort(sortArr, 0, sortArr.length - 1);
    }

    /**
     * 快速排序
     *
     * @param sortArr
     * @param leftPos  左哨兵
     * @param rightPos 右哨兵
     */
    public void quickSort(int[] sortArr, int leftPos, int rightPos) {
        if (leftPos > rightPos) {
            return;
        }

        int i = leftPos; //左哨兵
        int j = rightPos; //右哨兵
        int refer = sortArr[leftPos]; //参照值
        int temp = 0; //临时值

        while (i != j) {
            while (sortArr[j] >= refer && i < j) {
                j--;
            }

            while (sortArr[i] <= refer && i < j) {
                i++;
            }

            if (i < j) { //当哨兵i和哨兵j没有相遇时
                temp = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = temp;
            }
        }

        //最终将基数归位
        temp = sortArr[i];
        sortArr[i] = sortArr[leftPos];
        sortArr[leftPos] = temp;

        //递归
        quickSort(sortArr, leftPos, i - 1); //处理参照值左边的
        quickSort(sortArr, i + 1, rightPos); //处理参照值右边的
    }
}
