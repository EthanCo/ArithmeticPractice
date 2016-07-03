package com.ethanco.myarithmetictest.sort;

/**
 * Created by EthanCo on 2016/7/2.
 */
public interface ISort {
    /**
     * 1.桶排序
     * 非常浪费空间
     */
    void drumSort();

    /**
     * 2.冒泡排序
     * 时间复杂度大 - 效率低
     */
    void bubbeSort(int[] arr);

    /**
     * 快速排序
     * 不浪费空间，速度比冒泡排序快
     */
    void quickSort(int[] sortArr);
}
