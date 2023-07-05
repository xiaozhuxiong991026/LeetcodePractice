package Sort;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/27 16:15
 */

/*
 *
 *
 * 快排
 * 递归-- 每次找到一个基准位置 然后2侧的递归继续找
 *
 *
 * */
public class Quick_sort {
    public static void QuickSort(int[] arr, int start, int end) {
        // 递归结束
        if (start >= end) {
            return;
        }
        // 记录本轮参与排序的开始和结束位置
        int i = start;
        int j = end;
        // 选择第一个数作为基准数
        int baseval = arr[start];

        while (i < j) {
            // 从右向左找比基准数小的
            while (arr[j] >= baseval && i < j) {
                j--;
            }
            // 将右边比基准值小的放到左边来
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            // 从左向右找比基准值大的
            while (arr[i] <= baseval && i < j) {
                i++;
            }
            // 将左边比基准值大的放到右边来
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        // 基准值归位
        arr[i] = baseval;
        // 以基准值为分界线 递归处理两边
        QuickSort(arr, start, i - 1);
        QuickSort(arr, i + 1, end);
    }


    public static void main(String[] args) {
        Get_test get = new Get_test();
        int[] test = get.get_test(10);
        System.out.println(Arrays.toString(test));
        QuickSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }
}
