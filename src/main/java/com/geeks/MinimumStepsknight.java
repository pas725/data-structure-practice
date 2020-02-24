package com.geeks;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Created by piyush_sagar on 11/1/19.
 */
public class MinimumStepsknight {
    public static void main(String[] args) {
        int N = 5;
        int knightPos[] = {3, 3};
        int targetPos[] = {1, 5};
        int res = minStepToReachTarget(knightPos, targetPos, N);
        System.out.println(res);

        ClassLoader thi = MinimumStepsknight.class.getClassLoader();
        System.out.println(thi.toString());
        System.out.println(thi.getParent().toString());
        System.out.println(thi.getParent());
    }

    private static int minStepToReachTarget(int[] knightPos, int[] targetPos, int n) {

        int movesX[] = {-2, -2, -1, -1, 2, 2, 1, 1};
        int movesY[] = {1, -1, -2, 2, 1, -1, -2, 2};

        boolean visited[][] = new boolean[n][n];

        Queue<Cell> q = new ArrayDeque<>();
        q.add(new Cell(knightPos[0]-1, knightPos[1]-1, 0));
        visited[knightPos[0]-1][knightPos[1]-1] = true;

        while (!q.isEmpty()) {
            Cell c = q.poll();

            if (c.x == targetPos[0]-1 && c.y == targetPos[1]-1)
                return c.distance;

            for (int i = 0; i <8 ; i++) {
                int tmpX = c.x + movesX[i];
                int tmpY = c.y + movesY[i];

                if (isWithin(tmpX, tmpY, n) && !visited[tmpX][tmpY]) {
                    q.add(new Cell(tmpX, tmpY, c.distance + 1));
                    visited[tmpX][tmpY] = true;
                }
            }
        }

        return -1;
    }

    private static boolean isWithin(int tmpX, int tmpY, int n) {
        return tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < n;
    }

    static class Cell {
        int x;
        int y;
        int distance;

        public Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static int minStepToReachTarget(int n, int a, int b) {

        int movesX[] = {-a, -a, -b, -b, a, a, b, b};
        int movesY[] = {b, -b, -a, a, b, -b, -a, a};
        int[] knightPos = {1, 1};
        int[] targetPos = {n, n};

        boolean visited[][] = new boolean[n][n];

        Queue<Cell> q = new ArrayDeque<>();
        q.add(new Cell(knightPos[0]-1, knightPos[1]-1, 0));
        visited[knightPos[0]-1][knightPos[1]-1] = true;

        while (!q.isEmpty()) {
            Cell c = q.poll();

            if (c.x == targetPos[0]-1 && c.y == targetPos[1]-1)
                return c.distance;

            for (int i = 0; i <8 ; i++) {
                int tmpX = c.x + movesX[i];
                int tmpY = c.y + movesY[i];

                if (isWithin(tmpX, tmpY, n) && !visited[tmpX][tmpY]) {
                    q.add(new Cell(tmpX, tmpY, c.distance + 1));
                    visited[tmpX][tmpY] = true;
                }
            }
        }

        return -1;
    }


}
