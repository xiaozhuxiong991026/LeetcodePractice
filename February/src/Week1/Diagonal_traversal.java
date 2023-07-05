package Week1;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/8 16:27
 */

/*
* 对角线遍历
给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
*
* 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,4,7,5,3,6,8,9]
示例 2：

输入：mat = [[1,2],[3,4]]
输出：[1,2,3,4]

* */
/*
* 画图总结规律：
（1）先得出遍历的次数，也就是对角线的条数为i=n+m-1，所以数组遍历条件也就是i<n+m-1。
（2）在看图，对角线上的每个元素坐标之和为i,也就是元素的坐标xy与i的关系为：x+y=i
（3）如何遍历？看图中，偶数对应的对角线上的元素是从下往上遍历，而奇数对应的对角线上的元素是从上往下遍历，那么只要确定遍历的起始点和结束点就好啦！我们先看偶数对角线的起点和终点，因为奇数对角线和它相反，知道了偶数的，也不难得出奇数的的。

当i<n-1时，起始点坐标x=i，如1的x坐标为0，i也为0,结束点的横坐标x=0
当i>=n-1时，起始点坐标x=n-1,如2的x坐标为2，i也为2,结束点的纵坐标y=m-1,根据（2）中的关系式,所以得出横坐标x=i-(m-1)
所以偶数对角线遍历时起始点的x的坐标为min(i,n-1)，结束点的x坐标为max(0,i-(m-1)),而坐标y就是i-x

*
*
*
* */
public class Diagonal_traversal {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;//行数
        int m = mat[0].length;//列数
        int[] result = new int[mat.length * mat[0].length];//存储结果的数组
        for (int i = 0,final_num = 0;i < mat.length + mat[0].length - 1; i++) {
            if (i % 2 == 0) {
                for(int x=Math.min(i,n-1);x>=Math.max(0,i-m+1);x--){
                    result[final_num++] = mat[x][i-x];
                }
            } else {
                for(int x=Math.max(0,i-m+1);x<=Math.min(i,n-1);x++){
                    result[final_num++] = mat[x][i-x];
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Diagonal_traversal solution = new Diagonal_traversal();
        int[] result = solution.findDiagonalOrder(mat);
        System.out.println(Arrays.toString(result));


    }
}


