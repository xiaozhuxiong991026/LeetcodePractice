package Week2;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/16 21:14
 */


/*
* 在 MATLAB 中，有一个非常有用的函数 reshape
* 它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。

给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c
分别表示想要的重构的矩阵的行数和列数。
重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；
* 否则，输出原始矩阵。


示例 1：
输入：mat = [[1,2],[3,4]], r = 1, c = 4
输出：[[1,2,3,4]]
*
示例 2：
输入：mat = [[1,2],[3,4]], r = 2, c = 4
输出：[[1,2],[3,4]]

* */
public class Remolding_matrix {
    //个人思路 ： 转化为一维数组再填充到新的二维数组中
    /*public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c != mat.length*mat[0].length){
            return mat;
        }
        else{
            int[] temp = new int[r*c];
            int num = 0;
            int [][] newMat = new int[r][c];
            for (int[] ints : mat) {
                for (int j = 0; j < mat[0].length; j++) {
                    temp[num++] = ints[j];
                }
            }
            System.out.println(Arrays.toString(temp));
            for (int i = 0; i < r; i++) {
                for (int j = 0; j <c ; j++) {
                    newMat[i][j] = temp[i*c+j];
                }
            }
            return newMat;
        }*/

        // 参考方法  一次遍历即可
        public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length != 0 && mat.length * mat[0].length != r * c) {
            return mat;
        }
        int m = 0; //新数组行
        int n = 0; //新数组列
        int[][] res = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (n == c) { //满行进位
                    m++;
                    n = 0;
                }
                res[m][n] = mat[i][j];
                n++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 2;
        int c = 2;
        int [][] result = matrixReshape(mat, r, c);
        System.out.println(Arrays.deepToString(result));
    }
}
