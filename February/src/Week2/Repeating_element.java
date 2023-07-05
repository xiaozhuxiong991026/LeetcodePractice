package Week2;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/13 21:07
 */
/*
* 给你一个整数数组 nums 。
* 如果任一值在数组中出现 至少两次 ，返回 true ；
* 如果数组中每个元素互不相同，返回 false 。
 

示例 1：

输入：nums = [1,2,3,1]
输出：true
示例 2：

输入：nums = [1,2,3,4]
输出：false
示例 3：

输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true
 
*
*
*
* */
public class Repeating_element {
    //思路简单 但是复杂度太高 oj过不去
    public static boolean repeating_element_low(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //1.排序原数组
    //2.比较相邻两个元素的值
    //这样可以减去很多无用的比较
    public static boolean repeating_element_high(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4};
        System.out.println(repeating_element_low(test));
        System.out.println(repeating_element_high(test));

    }
}
