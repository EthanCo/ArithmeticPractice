package com.ethanco.myarithmetictest.graph;

/**
 * 第五章 图的遍历 第一节 广度优先
 * <p/>
 * Created by EthanCo on 2016/9/10.
 */
public class GraphTest2 {
    private static int sum = 0;
    private static int n = 5;
    private static int[][] e = {
            {0, 1, 1, 2, 1},
            {1, 0, 2, 1, 2},
            {1, 2, 0, 2, 1},
            {2, 1, 2, 0, 2},
            {1, 2, 1, 2, 0}
    };
    private static int[] book = new int[5];



    public static void main(String[] args) {
        //队列初始化
        int head = 0, tail = 0;

        //从1号顶点出发，将1号顶点加入队列

    }
}
