package Week1;

/**
 * @Author Aurora_zh
 * @Date 2023/2/7 20:03
 */


/*
搜索数组 插入target
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

*/
public class insert_Nums {

//暴力解法  没有技巧

    /*public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }*/
// 利用二分查找
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        insert_Nums ins = new insert_Nums();
        System.out.println(ins.searchInsert(nums, target));
    }
}
