package Week1;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/8 14:55
 */

/*零矩阵
编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。

 

示例 1：

输入：
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出：
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
*
* */
public class Zero_matrix {
    public void setZeroes(int[][] matrix) {

        int M = matrix.length;//行数
        int N = matrix[0].length;//列数

        int[] rowRecord = new int[M];
        int[] colRecord = new int[N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    rowRecord[i] = 1;
                    colRecord[j] = 1;
                }
            }
        }

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {
                if (rowRecord[row] == 1 || colRecord[col] == 1) {
                    matrix[row][col] = 0;
                }
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("Before:");
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println(Arrays.deepToString(matrix));
        Zero_matrix Solution = new Zero_matrix();
        Solution.setZeroes(matrix);
        System.out.println("After:");
        System.out.println(Arrays.deepToString(matrix));

    }
}
