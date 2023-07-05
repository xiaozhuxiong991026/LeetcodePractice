package Week1;

/**
 * @Author Aurora_zh
 * @Date 2023/2/7 19:07
 */

/*寻找数组的中心索引
* Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

 

Example 1:

Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

* */

/*思路：1.最蠢的办法是遍历 求flag的左侧之和和右侧之和，判断是否相等
        2.先求总和  这样 判断 左和*2 + flag 和 总和的关系就可以了
*
* */
public class SunMiddle {
    /* public int pivotIndex(int[] nums) {
         for(int i=0;i<nums.length;i++){
             int sum_right = 0;
             for(int right = 0; right<i;right++){
                 sum_right = sum_right + nums[right];
             }
             int sum_left = 0;
             for(int left = i+1;left< nums.length; left++){
                 sum_left = sum_left + nums[left];
             }
             if(sum_left == sum_right){
                 return i;
             }
         }
         return -1;
     };*/
/*    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        System.out.println(sum);
        if (sum == nums[0]) return 0;
        for (int flag = 1; flag < nums.length; flag++) {
            int sum_left = 0;
            for (int j = 0; j < flag; j++) {
                sum_left = sum_left + nums[j];
            }
            if (sum_left * 2 == sum - nums[flag]) {
                return flag;
            }
        }
        return -1;

    }*/

    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;

        //求和
        for(int i : nums){
            sum += i;
        }
        //找中心
        for(int i=0; i<nums.length; i++){
            if(leftSum==(sum-leftSum-nums[i])) return i;
            leftSum += nums[i];
        }
        return -1;



    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        SunMiddle solution = new SunMiddle();
        System.out.println(solution.pivotIndex(nums));
    }

}
