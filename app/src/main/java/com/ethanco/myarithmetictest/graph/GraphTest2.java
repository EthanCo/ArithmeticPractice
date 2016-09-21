package com.ethanco.myarithmetictest.graph;

import java.util.ArrayList;
import java.util.List;

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

    private static List<Integer> que = new ArrayList<>();

    public static void main(String[] args) {
        //队列初始化
        int head = 0, tail = 0;

        //从1号顶点出发，将1号顶点加入队列
        que.add(0);
        tail++;
        book[0] = 1; //标记1号顶点已访问

        //当队列不为空的时候循环
        while (head < tail) {
            int cur = que.get(head);
            for (int i = 0; i < n; i++) {
                if (e[cur][i] == 1 && book[i] == 0) {
                    que.add(i);
                    tail++;
                    book[i] = 1; //标记顶点i已访问
                }

                //如果tail大于n，则表明所有顶点都已经被访问过
                if (tail > n) {
                    break;
                }
            }
            head++;
        }

        for (int i = 0; i < tail; i++) {
            System.out.println(que.get(i)+1);
        }
    }
}
