package com.ethanco.myarithmetictest.sort;

/**
 * Created by EthanCo on 2016/7/2.
 */
public class SortReview implements ISort {
    @Override
    public void drumSort() {

    }

    @Override
    public void bubbeSort(int[] arr) {

    }

    @Override
    public void quickSort(int[] sortArr) {
        quickSort(sortArr, 0, sortArr.length - 1);
    }

    public void quickSort(int[] sortArr, int leftPos, int rightPos) {
        if (leftPos > rightPos) {
            return;
        }

        int i = leftPos; //左哨兵
        int j = rightPos; //右哨兵
        int refer = sortArr[leftPos];
        int temp = 0;

        while (i != j) {
            while (sortArr[j] >= refer && i < j) {
                j--;
            }

            while (sortArr[i] <= refer && i < j) {
                i++;
            }

            if (i < j) {
                temp = sortArr[i];
                sortArr[i] = sortArr[j];
                sortArr[j] = temp;
            }
        }

        temp = sortArr[i];
        sortArr[i] = sortArr[leftPos];
        sortArr[leftPos] = temp;

        quickSort(sortArr, leftPos, i - 1);
        quickSort(sortArr, i + 1, rightPos);
    }
}
