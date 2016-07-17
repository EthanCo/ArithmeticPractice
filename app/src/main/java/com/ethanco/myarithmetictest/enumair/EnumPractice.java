package com.ethanco.myarithmetictest.enumair;

/**
 * Created by EthanCo on 2016/7/3.
 */
public class EnumPractice {
    public static void main(String[] args) {
        //part1();
        //part3();
        part4();
    }

    //第3章 枚举!很暴力 第一节 坑爹的函数
    public static void part1() {
        int[] a = new int[10];
        int[] book = new int[10];
        int total = 0;
        int sum;

        for (a[1] = 1; a[1] <= 9; a[1]++)
            for (a[2] = 1; a[2] <= 9; a[2]++)
                for (a[3] = 1; a[3] <= 9; a[3]++)
                    for (a[4] = 1; a[4] <= 9; a[4]++)
                        for (a[5] = 1; a[5] <= 9; a[5]++)
                            for (a[6] = 1; a[6] <= 9; a[6]++)
                                for (a[7] = 1; a[7] <= 9; a[7]++)
                                    for (a[8] = 1; a[8] <= 9; a[8]++)
                                        for (a[9] = 1; a[9] <= 9; a[9]++) {
                                            //初始化book
                                            for (int i = 1; i <= 9; i++) {
                                                book[i] = 0;
                                            }

                                            //如果出现某个数就标记一下
                                            for (int i = 1; i <= 9; i++) {
                                                book[a[i]] = 1;
                                            }

                                            //统计共出现了多少个不同的数
                                            sum = 0;
                                            for (int i = 1; i <= 9; i++) {
                                                sum += book[i];
                                            }
                                            if (sum > 8) {
                                                System.out.println("sum:" + sum);
                                            }

                                            if (sum == 9) {
                                                if (a[1] * 100 + a[2] * 10 + a[3] + a[4] * 100 + a[5] * 10 + a[6] == a[7] * 100 + a[8] * 10 + a[9]) {
                                                    total++;
                                                    System.out.println("" + a[1] + a[2] + a[3] + a[4] + a[5] + a[6] + a[7] + a[8] + a[9]);
                                                }
                                            }
                                        }
        System.out.println("total:" + total / 2);
    }

    private static int calcCount(int number) {
        int count = 0;
        int[] f = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        while (number / 10 != 0) {
            count += f[number % 10];
            number /= 10;
        }

        count += f[number];
        return count;
    }

    //第3章 枚举!很暴力 第二节 火柴棍等式
    public static void part3() {
        int a, b, c, sum = 0;
        int m = 24;

        for (a = 0; a <= 11111; a++) {
            for (b = 0; b <= 11111; b++) {
                c = a + b;
                if (calcCount(a) + calcCount(b) + calcCount(c) == m - 4) {
                    System.out.println("" + a + "+" + b + "=" + c);
                    sum += 1;
                }
            }
        }

        System.out.println("sum:" + sum);
    }

    //第3章 枚举!很暴力 第四节 数的全排列
    public static void part4() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    System.out.println("" + i + j + k);
                }
            }
        }
    }
}
