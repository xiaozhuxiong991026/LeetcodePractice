package Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Aurora_zh
 * @Date 2023/2/7 20:26
 */

/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 合并数组

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

*/
public class Consolidation_interval {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return intervals;
        }
        //先将初始数组递增排序
        //可以理解为 a要插入排序的队列 箭头后面的返回是正的  就插入到b之后
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                result.add(temp);
                temp = intervals[i];
            }
        }
        result.add(temp);
        int[][] test1 = new int[result.size()][2];
        result.toArray(test1);
        return test1;
    }
   /* public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        // 1. 对二维数组按照第一列升序排序
        // 后面就是一个比较器 相当于给前面的排序设置了一个比较的依据
        // 如果后面是 (a,b) -> a - b  就是从a到b 升序
        // 如果是 (a,b) -> b - a 就是从b到a 升序

        // 可以理解为 a要插入排序的队列 箭头后面的返回是正的  就插入到b之后
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        //2、进行合并数组
        List<int[]> list = new ArrayList<>();
        int[] term = intervals[0];//临时空间，1 判断是否需要合并集合，2 是否放入结果集
        for (int i = 1; i < intervals.length; i++) {
            if (term[1] >= intervals[i][0]) {
                term[1] = Math.max(term[1], intervals[i][1]);
            } else {
                list.add(term);
                term = intervals[i];
            }
        }
        list.add(term);
        return list.toArray(new int[list.size()][2]);
    }*/


    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(test));
        Consolidation_interval solution = new Consolidation_interval();
        int[][] output = solution.merge(test);
        System.out.println(Arrays.deepToString(output));

    }
}
