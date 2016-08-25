package com.ethanco.myarithmetictest.enumair;

/**
 * 第4章 万能的搜索 第三章 层层递进-广度优先搜索
 * Created by EthanCo on 2016/7/3.
 */
public class EnumPractice4 {


    static class Note {
        int x; //横坐标
        int y; //纵坐标
        int f; //父亲在队列中的编号，本题不要求输出路径，可以不需要
        int step; //步数
    }

    public static void main(String[] args) {
        Note[] que = new Note[2501];

        int[][] a = new int[][]{
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 1}
        };

        int[][] book = new int[51][51];

        //定义一个用于表示走的方向的数组
        int[][] next = new int[][]{
                {0, 1}, //向右走
                {1, 0}, //向下走
                {0, -1},//向左走
                {-1, 0} //向上走
        };

        int head = 1, tail = 1;

        int k, n, m, startx, starty, p, q, tx, ty, flag;

        n = 4; //迷宫的行
        m = 3; //迷宫的列

        //小哈的位置
        p = 3;
        q = 4;

        startx = 1;
        starty = 1;

        //队列初始化
        head = 1;
        tail = 1;
        //往队列插入迷宫入口坐标
        Note note = new Note();
        note.x = startx;
        note.y = starty;
        note.f = 0;
        note.step = 0;
        que[tail] = note;
        tail++;
        book[startx][starty] = 1;

        flag = 0; //用来标记是否达到目标点，0表示暂时还没有达到，1表示达到
        while (head < tail) {
            //枚举4种走法
            for (k = 0; k <= 3; k++) {
                //计算的下一个点的坐标
                tx = que[head].x + next[k][0];
                ty = que[head].y + next[k][1];
                System.out.println("tx:" + tx + " head:" + head + " que[head].x:" + que[head].x + " next[k][0]:" + next[k][0]);
                System.out.println("ty:" + ty + " head:" + head + " que[head].y:" + que[head].y + " next[k][1]:" + next[k][1]);

                //判断(tx,ty)是否越界，是否为障碍物，以及这个点是否已经在路径中
                if (tx < 1 || tx > n || ty < 1 || ty > m) {
                    continue;
                }
                if (a[tx][ty] == 0 && book[tx][ty] == 0) {
                    book[tx][ty] = 1; //标记这个点已经走过

                    //插入新的点到队列中
                    Note note1 = new Note();
                    note1.x = tx;
                    note1.y = ty;
                    note1.f = head;
                    note1.step = que[head].step + 1;
                    que[tail] = note1;
                    int i = tail;
                    Note note2 = que[i];
                    System.out.print("M i=" + i + " que[i].x:" + note2.x + " que[i].y:" + note2.y + " que[i].step:" + note2.step + " que[i].f:" + note2.f);
                    tail++;
                }
                if (tx == p && ty == q) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
            head++;
            System.out.println("tail:" + tail);
            for (int i = 1; i < tail; i++) {
                Note note2 = que[i];
                System.out.print("i=" + i + " que[i].x:" + note2.x + " que[i].y:" + note2.y + " que[i].step:" + note2.step + " que[i].f:" + note2.f);
                System.out.println();
            }
            System.out.println("Head+++++++++++++++++++++++++++++++++++++++ " + head);
        }

        Note note3 = que[tail - 1];
        System.out.println();
        System.out.println("flag:" + flag + " setp:" + note3.step);
    }
}
