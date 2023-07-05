package Sort;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/10 21:18
 */


/*
*
1、从数组第2个元素开始抽取元素。

2、把它与左边第一个元素比较，如果左边第一个元素比它大，则继续与左边第二个元素比较下去
*   直到遇到不比它大的元素，然后插到这个元素的右边。

3、继续选取第3，4，....n个元素,重复步骤 2 ，选择适当的位置插入。
*
*
* */
public class Insert_sort {
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];//拿着arr[i]开始向前比较  记作temp
            for (int j = i - 1; j >= 0; j--) {
                if (temp < arr[j]) {
                    //一旦temp比前一个小 就将j处的值后移一位 j处暂时放入temp
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Get_test get_test = new Get_test();
        int[] test = get_test.get_test(10);
        System.out.println(Arrays.toString(test));
        insertSort(test);
        System.out.println(Arrays.toString(test));

    }
}
