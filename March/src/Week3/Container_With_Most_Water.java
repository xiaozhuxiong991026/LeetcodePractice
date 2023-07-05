package Week3;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @Author Aurora_zh
 * @Date 2023/3/15 19:24
 */

/*
*盛最多水的容器
给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。
*
*输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
* 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
*
示例 2：
输入：height = [1,1]
输出：1

* */
public class Container_With_Most_Water {
    /*
     * 思路：
     * 1. (有错，没有考虑到长度  只考虑了高度)
     * max_index数组记录第i个挡板之前的最高挡板的位置
     * 如果 height[i] > height[max_index]，则最大水槽的面积max=height[max_index] * (i-max_index)
     * else max = height[i] * (i - max_index))
     * 总结max= min(height[i], height[max_index])*(i-max_index)
     * 2.O(n) 复杂度
     * 2个指针 一个指向头一个指向尾
     * 然后前后指针向内移动 那么不管哪个指针移动 长度都是减少一
     * 然后保证高度尽量大
     * 面积就会最大
     *
     *
     *
     * */
    public static void main(String[] args) {
        int[] height = {1,2,1};
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height){
        int size = height.length;
        int left = 0,right = size - 1;
        int area = 0;
        while (left < right){
            area = max(area,(right - left)* min(height[left],height[right]));
            //尽量取两侧高度最高的
            if (height[left] > height[right]) {
                --right;
            } else {
                ++left;
            }
        }
        return area;
    }



   /* public static int maxArea(int[] height) {
        int[] max_index = max_index(height);
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = (i - max_index[i]) * (Math.min(height[i], height[max_index[i]]));
        }
        return max;
    }

    public static int[] max_index(int[] height) {
        int n = height.length;
        int[] result = new int[n];
        result[0] = 0;
        for (int i = 1; i < n; i++) {
            int max = height[0];
            result[i] = 0;
            for (int j = 1; j < i; j++) {
                if(height[j] > max){
                    max = height[j];
                    result[i] = j;
                }
            }
        }
        return result;
    }
*/

}
