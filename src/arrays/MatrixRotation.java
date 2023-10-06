package arrays;

import java.util.Arrays;

public class MatrixRotation {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
//        if not a square matrix, return
        if (n != matrix[0].length) {
            return;
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 100}, {4, 5, 6, 200}, {7, 8, 9, 300}, {12, 34, 26, 66}};
        System.out.println("Before Rotation:");
        System.out.println(Arrays.deepToString(matrix).replace("],", "]\n"));
        rotate(matrix);
        System.out.println("After Rotation:");
        System.out.println(Arrays.deepToString(matrix).replace("],", "]\n"));
    }
}

//       [[1, 2, 3]
//        [4, 5, 6]
//        [7, 8, 9]]

//       [[7, 4, 1]
//        [8, 5, 2]
//        [9, 6, 3]]

//   (0,0) ->   (2,0)     ->    (2,2)               -> (0,2)
//   (0,1) ->   (1,0)     ->    (2,1)               -> (1,2)
//   (0,2) ->   (0,0)     ->    (2,0)               -> (2,2)
//   (i,j) -> (n - 1 -j,i)-> (n - 1 - i, n - 1 -j)  -> (j, n - 1 - i)

