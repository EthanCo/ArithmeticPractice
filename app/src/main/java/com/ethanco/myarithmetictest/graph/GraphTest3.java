package com.ethanco.myarithmetictest.graph;

/**
 * 第五章 图的遍历 第二节 城市地图-图的深度优先遍历
 * <p/>
 * Created by EthanCo on 2016/9/10.
 */
public class GraphTest3 {
    private static int min = 999999999;
    private static int sum = 0;
    private static int n = 5;
    private static int[][] e = {
            {0, 2, -1, -1, 10},
            {-1, 0, 3, -1, 7},
            {4, -1, 0, 4, -1},
            {-1, -1, -1, 0, 5},
            {-1, -1, 3, -1, 0}
    };
    private static int[] book = new int[5];

    public static void main(String[] args) {
        book[0] = 1;
        dfs(0, 0);
        System.out.println(min);
    }

    /**
     * @param cur 当前所在城市编号
     * @param dis 已经走过的路程
     */
    static void dfs(int cur, int dis) {
        //如果当前走过的路程已经大于之前找到的最短路径，则没有必要再往下尝试了，立即返回
        if (dis > min) {
            return;
        }

        //判断是否到达了目标城市
        if (cur == (n-1)) {
            if (dis < min) {
                min = dis; //更新最小值
                return;
            }
        }

        for (int j = 0; j < n; j++) {
            //判断当前城市cur到城市j是否有路，并判断城市j是否在走过的路程中
            if (e[cur][j] != -1 && book[j] == 0) {
                book[j] = 1;
                dfs(j, dis + e[cur][j]);
                book[j] = 0; //之前一步探索完毕之后，取消对城市j的标记
            }
        }
    }
}
