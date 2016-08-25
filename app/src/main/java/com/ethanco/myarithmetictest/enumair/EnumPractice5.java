package com.ethanco.myarithmetictest.enumair;

import java.util.ArrayList;
import java.util.List;

/**
 * 第4章 万能的搜索 第四章 再解炸弹人
 * Created by EthanCo on 2016/7/3.
 */
public class EnumPractice5 {

    static class Note {
        public Note(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x; //横坐标
        int y; //纵坐标
    }

    static List<Note> queue = new ArrayList<>();
    static int head, tail;

    static final char[][] a = new char[][]{
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', 'G', 'G', ' ', 'G', 'G', 'G', '#', 'G', 'G', 'G', ' ', '#'},
            {'#', '#', '#', ' ', '#', 'G', '#', 'G', '#', 'G', '#', 'G', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', 'G', '#'},
            {'#', 'G', '#', ' ', '#', '#', '#', ' ', '#', 'G', '#', 'G', '#'},
            {'#', 'G', 'G', ' ', 'G', 'G', 'G', ' ', '#', ' ', 'G', 'G', '#'},
            {'#', 'G', '#', ' ', '#', 'G', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', '#', 'G', ' ', ' ', ' ', 'G', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', 'G', '#', ' ', '#', 'G', '#', '#', '#', ' ', '#', 'G', '#'},
            {'#', ' ', ' ', ' ', 'G', '#', 'G', 'G', 'G', ' ', 'G', 'G', '#'},
            {'#', 'G', '#', ' ', '#', 'G', '#', 'G', '#', ' ', '#', 'G', '#'},
            {'#', 'G', 'G', ' ', 'G', 'G', 'G', '#', 'G', ' ', 'G', 'G', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    };

    //定义一个用于表示走的方向的数组
    static final int[][] next = new int[][]{
            {0, 1}, //向右走
            {1, 0}, //向下走
            {0, -1},//向左走
            {-1, 0} //向上走
    };

    public static void main(String[] args) throws InterruptedException {

        int book[][] = new int[20][20];
        int startY = 3;
        int startX = 3;
        int my;
        int mx;

        //init
        head = 0;
        tail = 0;

        Note note = new Note(startY, startX);
        queue.add(note);
        tail++;
        book[startY][startX] = 1;

        int max = getNum(startY, startX);
        mx = startX;
        my = startY;
        System.out.println("max:" + max);

        int ty;
        int tx;
        int sum;

        while (head < tail) {
            for (int i = 0; i < 3; i++) {
                Note currNote = queue.get(head);
                ty = currNote.x + next[i][0];
                tx = currNote.y + next[i][1];

                //判断是否越界
                if (ty < 0 || ty >= a.length || tx < 0 || tx >= a[ty].length) {
                    continue;
                }

                //判断是否是平地或以前没走过

                if (a[ty][tx] != 'G'&&a[ty][tx] != '#' && book[ty][tx] == 0) {
                    //每个点只入队一次，所以需要标记这个点已经走过
                    book[ty][tx] = 1;
                    //插入新扩展的点到队列中
                    queue.add(new Note(ty, tx));
                    tail++;

                    //统计当前新扩展的点可以消灭的敌人总数
                    sum = getNum(ty, tx);
                    System.out.println("tx:" + ty + "ty:" + tx + "sum:" + sum);


                    if (sum > max) {
                        max = sum;
                        my = ty;
                        mx = tx;
                    }
                }
            }
            head++;
        }

        System.out.println("mx:" + my + " my:" + mx + "max:" + max);
    }

    /**
     * @param j x轴坐标
     * @param i y轴坐标
     * @return
     */
    static int getNum(int i, int j) {
        int sum, x, y;
        sum = 0;


        //向左统计可以消灭的敌人
        x = i;
        y = j;
        while (a[x][y] != '#') {
            if (a[x][y] == 'G') {
                sum++;
            }
            x--;
        }

        //向右统计可以消灭的敌人
        x = i;
        y = j;
        while (a[x][y] != '#') {
            if (a[x][y] == 'G') {
                sum++;
            }
            x++;
        }

        //向上统计可以消灭的敌人
        x = i;
        y = j;
        while (a[x][y] != '#') {
            if (a[x][y] == 'G') {
                sum++;
            }
            y--;
        }

        //向下统计可以消灭的敌人
        x = i;
        y = j;
        while (a[x][y] != '#') {
            if (a[x][y] == 'G') {
                sum++;
            }
            y++;
        }

        return sum;
    }
}

