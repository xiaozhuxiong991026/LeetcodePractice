package Week2;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/13 21:22
 */

/*
*最大子数组和
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

子数组 是数组中的一个连续部分。



示例 1：

输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：

输入：nums = [1]
输出：1
示例 3：

输入：nums = [5,4,-1,7,8]
输出：23

*
*
* 思路:  动态规划
* 从第一个数开始  （i + i+1） 和 i+1 进行比较
* 如果 前者大 就将i+1 放入最大子链
* 如果后者大 就从i+1 开始重新记录
* 注意随时更新max
* */
public class Max_subarray {
    public static int max_subarray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
       /* if (nums.length == 0)
            return 0;
        int max = nums[0];
        for (int a = 1; a < nums.length; a++) {
            nums[a] = Math.max(nums[a] + nums[a - 1], nums[a]);
            max = Math.max(max, nums[a]);
        }
        return max;*/
    }

    public static void main(String[] args) {
        int[] test = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(Arrays.toString(test));
        System.out.println(max_subarray(test));
    }
}
