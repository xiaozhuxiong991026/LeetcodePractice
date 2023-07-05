package Week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Aurora_zh
 * @Date 2023/2/16 21:31
 */


/*
* 杨辉三角
* 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
*
     *  1
     *  1 1
     *  1 2 1
     *  1 3 3 1
     *  1 4 6 4 1
     *  1 5 10 10 5 1

在「杨辉三角」中，每个数是它左上方和右上方的数的和。
示例 1:
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
*
示例 2:
输入: numRows = 1
输出: [[1]]
*
* */

public class Yang_Hui_Triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        //需要创建numRows个子链表
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            //第i行的子链表有i+1个元素
            for (int j = 0; j <= i; j++) {
                // 开头 和 结尾是 1
                if (j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                }
            }
            //每次的链表加入结果链表
            result.add(list);
        }
        return result;
    }



    public static void main(String[] args) {
        int numRows = 5;
       System.out.println(generate(numRows));
    }
}
