package com.ethanco.myarithmetictest.enumair;

/**
 * Created by EthanCo on 2016/7/3.
 */
public class EnumPractice {
    public void main(String[] args) {

        //第3章 枚举!很暴力 第一节 坑爹的函数
        int[] a = new int[10];
        int[] book = new int[10];
        int total = 0;
        int sum;

        for (a[1] = 0; a[1] < 9; a[1]++)
            for (a[2] = 0; a[2] < 9; a[2]++)
                for (a[3] = 0; a[3] < 9; a[3]++)
                    for (a[4] = 0; a[4] < 9; a[4]++)
                        for (a[5] = 0; a[5] < 9; a[5]++)
                            for (a[6] = 0; a[6] < 9; a[6]++)
                                for (a[7] = 0; a[7] < 9; a[7]++)
                                    for (a[8] = 0; a[8] < 9; a[8]++)
                                        for (a[9] = 0; a[9] < 9; a[9]++) {
                                            //初始化book
                                            for (int i = 0; i < book.length; i++) {
                                                book[i] = 0;
                                            }
                                        }
    }
}
