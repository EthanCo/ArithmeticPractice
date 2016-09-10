package com.ethanco.myarithmetictest.graph;

/**
 * 第五章 图的遍历 第一节 深度优先
 * <p>
 * Created by EthanCo on 2016/9/10.
 */
public class GraphTest1 {
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
        book[0] = 1; //标记1号顶点已访问
        dfs(0); //从1号顶点开始遍历
    }

    /**
     * @param cur 当前所在的顶点编号
     */
    static void dfs(int cur) {
        System.out.println((cur+1));
        sum++;
        if (sum == n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            if (e[cur][i] == 1 && book[i] == 0) {
                book[i] = 1; //标记顶点i已经被访问过
                dfs(i); //从顶点i再出发继续遍历
            }
        }

        return;
    }


}
