package com.ethanco.myarithmetictest.enumair;

/**
 * 第4章 万能的搜索 解救小哈
 * Created by EthanCo on 2016/7/3.
 */
public class EnumPractice3 {

    public static void main(String[] args) {
        int startX = 0, startY = 0;

        //读入地图
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//
//            }
//        }

        a = new int[][]{
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 1}
        };

        p = 3;
        q = 2;

        n = a.length;
        m = a[0].length;

        book[startX][startY] = 1;  //标记起点已经在路径中，防止后面重复走，防止后面重复走

        //第一个参数是起点的x坐标，第二个参数是起点的y坐标，第三个参数是初始步数为0
        dfs(startX, startY, 0);

        System.out.println("min:" + min);
    }

    static int
            n, //地图的x轴长度
            m, //地图的y轴长度
            p, //小哈的x坐标
            q, //小哈的y坐标
            min = Integer.MAX_VALUE; //最小的步数

    //按照右、下、左、上的顺序尝试
    static int[][] next = new int[][]{
            {0, 1}, //向右走
            {1, 0}, //向下走
            {0, -1},//向左走
            {-1, 0} //向上走
    };
    static int a[][] = new int[51][51];
    static int book[][] = new int[51][51];

    /**
     * @param x    x坐标
     * @param y    y坐标
     * @param step 当前以及走过的步数
     */
    public static void dfs(int x, int y, int step) {
        //判断是否到达小哈的位置
        System.out.println("x=" + x + ";y=" + y);
        if (x == p && y == q) {
            System.out.println("dfs min:" + min + ",step=" + step);
            //更新最小值
            if (step < min) {
                min = step;
                System.out.println("update dfs min:" + min);
            }
            return; //请注意这里的返回很重要
        }

        int tx, ty;
        //枚举4种走法
        for (int k = 0; k <= 3; k++) {
            //计算的下一个点的坐标
            tx = x + next[k][0];
            ty = y + next[k][1];

            //判断(tx,ty)是否越界，是否为障碍物，以及这个点是否已经在路径中
            if (tx < 0 || tx >= n || ty < 0 || ty >= m) {
                continue;
            }
            if (a[tx][ty] == 0 && book[tx][ty] == 0) {
                book[tx][ty] = 1; //标记这个点已经走过
                dfs(tx, ty, step + 1); //开始尝试下一个点
                book[tx][ty] = 0; //尝试结束，取消这个点的标记
            }
        }
    }
}
