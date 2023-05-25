package com.arrays.dynamicProgramming;

/**
 * Created by psagar on 9/14/2017.
 */
public class MaxApplesInGrid {
    static int cnt = 0;
    public static void main(String[] args) {
        int grid[][] = {{1,3,4},{3,5,6},{1,2,0}};
        int memo[][] = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        //System.out.println(maxApples(grid,0,0,3, memo));
        System.out.println(maxApplesSimple(grid,3));
        System.out.println("Call count : "+cnt);
    }

    public static int maxApplesSimple(int grid[][], int n) {
        for(int i=0; i<n ;i++) {
            for(int j=0; j<n ;j++) {
                int sum = grid[i][j];
                int below = 0;
                if (i>0) {
                    below = grid[i-1][j];
                }
                int side = 0;
                if(j>0) {
                    side = grid[i][j-1];
                }
                grid[i][j] = sum + Math.max(below, side);
            }
        }
        return grid[n-1][n-1];
    }

    public static int maxApples(int grid[][], int i, int j, int n, int memo[][]) {
        if (i<n) {
            cnt++;
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int max = grid[i][j];
            int nextColCount = 0;
            int nextRowCount = 0;
            if (j < n-1) {
                nextColCount = maxApples(grid,i, j+1, n, memo);
            }

            if (i < n-1) {
                nextRowCount = maxApples(grid,i+1, j, n, memo);
            }
            max += Math.max(nextColCount, nextRowCount);
            memo[i][j] = max;
            return max;
        }
        return 0;
    }
}
