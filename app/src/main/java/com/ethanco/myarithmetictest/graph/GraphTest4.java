package com.ethanco.myarithmetictest.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 第五章 图的遍历 第三节 最少转机-图的广度优先遍历
 * <p/>
 * Created by EthanCo on 2016/9/10.
 */
public class GraphTest4 {
    private static int flag;

    static class Note {
        int x; //城市编号
        int s; //转机次数

        public Note(int x, int s) {
            this.x = x;
            this.s = s;
        }
    }

    private static int sum = 0;
    private static int n = 5;
    //-1 不可达 ， 0 同一城市为0
    private static int[][] e = {
            {0, 1, 1, -1, -1},
            {-1, 0, 1, 1, -1},
            {-1, -1, 0, 1, 1},
            {-1, -1, -1, 0, 1},
            {-1, -1, -1, -1, 0}
    };
    private static int[] book = new int[5];

    private static List<Note> que = new ArrayList<>();

    public static void main(String[] args) {
        //队列初始化
        int head = 0, tail = 0;
        //start 开始城市 end 结束城市
        int start = 0, end = 4;

        //从1号顶点出发，将1号顶点加入队列
        que.add(new Note(start, 0));
        tail++;
        book[start] = 1; //标记1号顶点已访问

        //当队列不为空的时候循环
        while (head < tail) {
            Note note = que.get(head);
            int cur = note.x;
            for (int j = 0; j < n; j++) {
                System.out.println("cur:" + cur + " j:" + j +" "+ e[cur][j]);
                if (e[cur][j] == 1 && book[j] == 0) {
                    que.add(new Note(j, que.get(head).s + 1)); //转机次数 +1
                    tail++;
                    //标记城市j已经在队列中
                    book[j] = 1;
                }

                //如果到达目标城市，停止扩展，任务结束，退出循环
                if (que.get(tail - 1).x == end) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }

            head++;
        }

        System.out.println(que.get(tail - 1).s);
    }
}
