package com.ethanco.myarithmetictest.shortest_path;

/**
 * Dijkstra算法
 * Created by EthanCo on 2016/9/21.
 */
public class shortestTest1 {

    static final int inf = 99999999;

    static int[][] e = new int[][]{
            {0, 1, 12, inf, inf, inf},
            {inf, 0, 9, 3, inf, inf},
            {inf, inf, 0, inf, 5, inf},
            {inf, inf, 4, 0, 13, 15},
            {inf, inf, inf, inf, 0, 4},
            {inf, inf, inf, inf, inf, 0},
    };

    public static void main(String[] args) {

        //初始化dis数组
        int[] dis = new int[e[0].length];
        for (int i = 0; i < e.length; i++) {
            dis[i] = e[0][i];
        }

        //初始化book数组
        int[] book = new int[e[0].length];
        book[0] = 1;

        //Dijkstra算法核心
        int min, u = 0;
        for (int i = 0; i < e[0].length - 2; i++) {
            //找到离1号顶点最近的顶点
            min = inf;

            //需找到离远点最近且未知最短路径的顶点u (由于每次找到的都可能有改变，所以每次都要寻找)
            for (int j = 0; j < e[0].length - 1; j++) {
                if (book[j] == 0 && dis[j] < min) {
                    min = dis[j];
                    u = j;
                }
            }
            book[u] = 1; //记录为已知最短路径

            //松弛
            for (int v = 0; v < e[0].length; v++) {
                if (e[u][v] < inf) {
                    if (dis[v] > dis[u] + e[u][v]) {
                        dis[v] = dis[u] + e[u][v];
                    }
                }
            }
        }

        for (int i = 0; i < e[0].length; i++) {
            System.out.print(dis[i] + " ");
        }
    }
}
