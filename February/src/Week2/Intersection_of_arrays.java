package Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Aurora_zh
 * @Date 2023/2/15 15:23
 */

/*
*
* 两个数组的交集 II
给你两个整数数组 nums1 和 nums2
* 请你以数组形式返回两数组的交集
* 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致
* （如果出现次数不一致，则考虑取较小值）
* 可以不考虑输出结果的顺序。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
示例 2:

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9]
*
*
* */
public class Intersection_of_arrays {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        for (int num : nums1) {
            list1.add(num);
        }
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums2) {
            if (list1.contains(num)) {
                list2.add(num);
                // 从 list1 除去已匹配的数值
                list1.remove(Integer.valueOf(num));
            }
        }
        return list2.stream().mapToInt(Integer::intValue).toArray();


    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }


}
