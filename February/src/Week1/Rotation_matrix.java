package Week1;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/8 11:04
 */
/*二维数组顺时针90度翻转

* iven a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
* */
public class Rotation_matrix {
    public void rotate(int[][] matrix) {
        int[][] temp = new int[matrix.length][matrix.length];
        //换位
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                temp[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        //再将temp拷贝给matrix
        for(int i = 0; i<matrix.length; i++) {
            System.arraycopy(temp[i], 0, matrix[i], 0, matrix[i].length);
        }
    }

    public static void main(String[] args) {
        System.out.println("原matrix:");
        int [][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(matrix));
        Rotation_matrix solution = new Rotation_matrix();
        solution.rotate(matrix);
        System.out.println("反转后的matrix:");
        System.out.println(Arrays.deepToString(matrix));
    }
}
