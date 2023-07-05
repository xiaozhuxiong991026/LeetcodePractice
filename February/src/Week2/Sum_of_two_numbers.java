package Week2;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/14 15:45
 */


/*
*
给定一个整数数组 nums 和一个整数目标值 target
* 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。
* 但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。



示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]

*
*
*
* 思路：
* 排序数组
* 循环遍历数组 二分查找 target-arr[i] 是否在后面的数组中
*
*
*
*
* */
public class Sum_of_two_numbers {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            result[0] = i;
            int target_left = target - nums[i];
            int[] temp = Arrays.copyOfRange(nums, i + 1, nums.length);
            System.out.println(nums[i]);
            System.out.println(target_left);
            System.out.println(Arrays.toString(temp));
            result[1] = search(temp, target_left) + i + 1;
            if (result[1] >= 0) {
                break;
            }
        }
        return result;
    }

    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -100;
    }


    public static void main(String[] args) {
        int[] test = new int[]{16142,8192,10239};
        System.out.println(Arrays.toString(twoSum(test, 18431)));
    }
}
