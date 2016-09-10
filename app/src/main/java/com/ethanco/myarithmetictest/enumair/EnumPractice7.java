package com.ethanco.myarithmetictest.enumair;

import java.util.ArrayList;
import java.util.List;

/**
 * 第4章 万能的搜索 第5章 宝岛探险 计算所在岛面积-深度搜索
 * Created by EthanCo on 2016/7/3.
 */
public class EnumPractice7 {

    static class Note {
        public Note(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;
    }

    //定义一个用于表示走的方向的数组
    static final int[][] next = new int[][]{
            {0, 1}, //向右走
            {1, 0}, //向下走
            {0, -1},//向左走
            {-1, 0} //向上走
    };

    static List<Note> que = new ArrayList<>();
    static int head = 0, tail = 0;
    static int[][] a = new int[][]{
            {1, 3, 4, 3, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 2, 0, 1, 1, 0, 0, 0},
            {1, 2, 1, 0, 0, 2, 2, 3, 0, 0},
            {0, 0, 0, 0, 0, 1, 3, 4, 3, 0},
            {0, 1, 1, 0, 0, 0, 1, 8, 7, 0},
            {0, 2, 2, 1, 0, 1, 3, 9, 8, 0},
            {0, 1, 3, 2, 1, 5, 6, 7, 6, 0},
            {0, 0, 2, 4, 5, 4, 2, 5, 0, 0},
            {2, 1, 0, 0, 3, 3, 1, 0, 1, 1},
            {3, 2, 1, 0, 0, 0, 0, 0, 2, 0}
    };
    static int[][] book = new int[50][50];
    static int startX = 5, startY = 7;
    static int sum = 0;

    static void dfs(int x, int y) {
        int tx, ty;
        for (int k = 0; k <= 3; k++) {
            //计算下一步的坐标
            tx = x + next[k][0];
            ty = y + next[k][1];

            //判断是否越界
            if (tx < 0 || tx >= a.length || ty < 0 || ty >= a[tx].length) {
                continue;
            }

            //判断是否是陆地
            if (a[tx][ty] > 0 && book[tx][ty] == 0) {
                sum++;
                book[tx][ty] = 1; //标记这个点已走过
                dfs(tx, ty); //开始尝试下一个点
            }
        }
    }

    public static void main(String[] args) {
        sum++;
        book[startX][startY] = 1;
        dfs(startX, startY);
        System.out.println("sum:" + sum);
    }
}

