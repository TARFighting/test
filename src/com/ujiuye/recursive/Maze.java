package com.ujiuye.recursive;

/**
 * Maze
 * 迷宫回溯
 * @author whx
 * @date 2021 /6/19 0019 14:19
 */
public class Maze {
    public static void main(String[] args) {
        //迷宫初始化
        int[][] map = mazeInitialize();
        //如果迷宫有解的话，将逃脱路线打印出来
        if(escape(map,1,1)) {
            for (int[] ints : map) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }else {
            System.out.println("此迷宫无解");
        }
    }

    /**
     * Maze initialize int [ ] [ ]
     * 迷宫初始化
     * @return the int [ ] [ ]
     */
    public static int[][] mazeInitialize() {
        int[][] map = new int[8][7];
        //迷宫外墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[7][0] = 1;
        map[7][6] = 1;

        //迷宫内墙
        map[2][2] = 1;
        map[3][1] = 1;
        map[3][2] = 1;
        map[3][3] = 1;
        map[3][4] = 1;
        map[5][2] = 1;
        map[5][3] = 1;
        map[5][4] = 1;
        map[5][5] = 1;
        return map;
    }

    /**
     * Escape boolean
     * 逃脱路线
     * @param map map
     * @param i 起点横坐标
     * @param j   起点纵坐标
     * @return the boolean
     */
    public static boolean escape(int[][] map,int i,int j) {
        //向前走的时候不能走墙和走过的路
        if(map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3) {
            return false;
        }
        map[i][j] = 2;
        //迷宫终点
        if (map[6][5] == 2) {
            return true;
        }else {
            //向下走
            if(escape(map,i + 1,j)) {
                return true;
            }
            //向右走
            else if(escape(map,i,j + 1)) {
                return true;
            }
            //向上走
            else if(escape(map,i - 1,j)) {
                return true;
            }
            //向左走
            else if(escape(map,i,j - 1)) {
                return true;
            }
            //上下左右都走不了，说明这是一条死路，标记为3，回退一步
            else {
                map[i][j] = 3;
                return false;
            }
        }
    }
}
