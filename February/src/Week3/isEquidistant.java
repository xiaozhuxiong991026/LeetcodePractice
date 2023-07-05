package Week3;

import java.math.BigDecimal;

/**
 * @Author Aurora_zh
 * @Date 2023/2/26 12:06
 */

/*

判断数组能否重构成等差数列

 */
public class isEquidistant {
    public static boolean Soulation(int[] nums) {
        //找到最大值和最小值
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int min = nums[0];
        for (Integer num : nums) {
            min = Math.min(num, min);
        }
        //计算公差  最大化保证精度
        BigDecimal a = new BigDecimal(max - min);
        BigDecimal b = new BigDecimal(nums.length - 1);
        double d = a.divide(b, 20, BigDecimal.ROUND_HALF_UP).doubleValue();//保留20位小数

        //遍历比较相邻两个数的差值是否是公差的倍数
        for (int i = 0; i < nums.length - 1; i++) {
            if (((nums[i] - nums[i + 1]) % d) != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,5,11};
        System.out.println(Soulation(nums));
    }
}
