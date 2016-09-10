package com.ethanco.myarithmetictest.enumair;

import java.util.ArrayList;
import java.util.List;

/**
 * 第4章 万能的搜索 第5章 宝岛探险 计算所在岛面积 - 广度优先
 * Created by EthanCo on 2016/7/3.
 */
public class EnumPractice6 {

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

    public static void main(String[] args) {
        List<Note> que = new ArrayList<>();
        int head = 0, tail = 0;
        int[][] a = new int[][]{
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
        int[][] book = new int[50][50];
        int startX = 5, startY = 7;
        int sum = 0;

        Note note = new Note(startX, startY);
        que.add(note);
        tail++;

        book[startX][startY] = 1;
        sum++;

        int tx, ty;
        while (head < tail) {
            //枚举四个方向
            for (int k = 0; k <= 3; k++) {
                //计算下一个的坐标
                Note tempNote = que.get(head);
                tx = tempNote.x + next[k][0];
                ty = tempNote.y + next[k][1];

                //判断是否越界
                if (tx < 0 || tx >= a.length || ty < 0 || ty >= a[tx].length) {
                    continue;
                }

                //判断是否是陆地或者曾经是否走过
                if (a[tx][ty] > 0 && book[tx][ty] == 0) {
                    sum++;
                    System.out.println("sum++ tx:" + tx + " ty:" + ty + "value:" + a[tx][ty]);

                    book[tx][ty] = 1;
                    //将新扩展的点加入队列
                    Note newNote = new Note(tx, ty);
                    que.add(newNote);
                    tail++;
                }
            }
            head++;
        }

        System.out.println("sum:" + sum);
    }
}

