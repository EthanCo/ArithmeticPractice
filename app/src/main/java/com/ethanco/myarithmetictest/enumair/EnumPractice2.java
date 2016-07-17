package com.ethanco.myarithmetictest.enumair;

/**
 * Created by EthanCo on 2016/7/3.
 */
public class EnumPractice2 {
    static int[] a = new int[10];
    static int[] book = new int[10];
    static int n;

    public static void main(String[] args) {
        n = 3;
        dfs(1);
    }

    public static void dfs(int step) { //setp表示现在站在第几个盒子面前
        if (step == n + 1) { //如果站在第n+1个盒子面前，则表示前几个盒子已经放好扑克牌
            //输出一种排列 (1~n号盒子的扑克牌编号)
            for (int j = 1; j <= n; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println("");
        }

        for (int i = 1; i <= n; i++) {
            //判断扑克牌i是否还在手上
            if (book[i] == 0) { //book[i]等于0表示i号扑克牌仍然在手上
                a[step] = i;  //将i号扑克牌放入到第setp个盒子中
                book[i] = 1; //将book[i]设为1,表示i号扑克牌已经不在手上

                //第step个盒子已经放好扑克牌，接下来需要走到下一个盒子面前
                dfs(step + 1); //这里通过烂熟的递归调用来实现(自己调用自己)
                book[i] = 0;   //这是非常重要的一步，一定要将刚才尝试的扑克牌收回，才能进行下一次尝试
            }
        }
    }
}
