package arrays;

import java.util.Arrays;

public class ZeroMatrix {
    /*
    If an element in MxN matrix is zero, its entire row and column is set to 0.
     */
    public static void setZero(int[][] matrix) {

        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
//              use the first row/col as the map to indicate whether the entire row/col is set to 0.
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRowZero = true;
                    }
                    if (j == 0) {
                        firstColZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
//        first row and col should be filled with 0 in the end
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setRowZero(matrix, i);
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                setColumnZero(matrix, i);
            }
        }

        if (firstRowZero) {
            setRowZero(matrix, 0);
        }
        if (firstColZero) {
            setColumnZero(matrix, 0);
        }
        System.out.println(Arrays.deepToString(matrix).replace("],", "]\n"));

    }

    public static void setColumnZero(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    public static void setRowZero(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 0, 6}, {7, 8, 9}, {10, 11, 12}};
        setZero(matrix);
    }

}
