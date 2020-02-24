package com.careercup.arrays_string;

/*
 * Created by piyush_sagar on 3/14/19.
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0,
 *
 * We can reduce the space to 0(1 ) by using the first row as a replacement for the row array and the first
    column as a replacement for the column afray. This works as follows:
    1. Check if the first row and first column have any zeros, and set variables rowHasZero and
    columnHasZero. [We'll nullify the first row and first column later, if necessary.)
    2. Iterate through the rest of the matrix, setting matrix[i ] [0 ] and matri x [0 ] [j ] to zero whenever
    there's a zero in matri x [ i] [j ].
    3. Iterate through rest of matrix, nullifying row i if there's a zero in matri x [i ] [0] .
    4. Iterate through rest of matrix, nullifying column j if there's a zero inmatrix[0 ] [ j] ,
    5. Nullify the first row and first column, if necessary (based on values from Step 1).
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,5,0},
                {1,2,0,5,6},
                {1,2,3,5,8},
                {1,0,3,5,9},
                {1,2,3,5,1}
        };

        makeRowColumnZero(matrix, matrix.length);
    }

    private static void makeRowColumnZero(int[][] matrix, int length) {
        boolean isRowZero = false;
        boolean isColZero = false;

        for(int row=0; row<length; row++) {
            for(int col=0; col<length; col++) {
                if (matrix[row][col] == 0) {
                    if (row == 0)
                        isRowZero = true;
                    else if (col == 0)
                        isColZero = true;
                    else {
                        matrix[row][0] = 0;
                        matrix[0][col] = 0;
                    }
                }
            }
        }

        for(int row=1; row<length; row++) {
            if (matrix[row][0] == 0) {
                fillZeroRow(matrix, row, length, 1);
            }
        }

        for(int col=1; col<length; col++) {
            if (matrix[0][col] == 0) {
                fillZeroCol(matrix, col, length, 1);
            }
        }

        if (isRowZero) {
            fillZeroRow(matrix, 0, length, 0);
        }

        if (isColZero) {
            fillZeroCol(matrix, 0, length, 0);
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        int length = matrix.length;
        for(int row=0; row<length; row++) {
            for (int col = 0; col < length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println("");
        }
    }

    private static void fillZeroRow(int[][] matrix, int row, int length, int start) {
        for (int i=start; i<length; i++) {
            matrix[row][i] = 0;
        }
    }

    private static void fillZeroCol(int[][] matrix, int col, int length, int start) {
        for (int i=start; i<length; i++) {
            matrix[i][col] = 0;
        }
    }
}
