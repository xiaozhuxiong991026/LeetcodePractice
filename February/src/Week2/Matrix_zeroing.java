package Week2;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/17 17:33
 */


/*
*. 矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。
*请使用 原地 算法。
示例 1：
输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
输出：[[1,0,1],[0,0,0],[1,0,1]]
*
示例 2：
输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

*思路 ：
* 1.遍历二维数组 将有0的行和列分别记录到数组中
* 2.遍历二维数组 判断每个数的行或者列是否被记录
* 3.有记录就让他为0

*
* */



public class Matrix_zeroing {
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] Zero_row = new boolean[row];
        boolean[] Zero_col = new boolean[col];
        //遍历完成行和列的 flag数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    Zero_row[i] = true;
                    Zero_col[j] = true;
                }
            }
        }
        // 遍历修改 原数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (Zero_row[i] || Zero_col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}
