package Sort;


import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/10 17:53
 */



/*
 * 选择排序
 * 循环遍历 原数组
 * 每次选一个最大的放在最后
 * 或者
 * 每次选一个最小的放在最前面
 *
 *
 * */
public class Select_sort {
    //找最小的 放在最前面
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //i 理解为位置
            // i处的数据和i之后的数据进行比较 如果之后的数据比i小 就替换掉i
            //依次替换完全部的位置
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


/*
    //找最大的 放在最后面
    public static void selectSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }
*/


    public static void main(String[] args) {
        Get_test get = new Get_test();
        int[] test = get.get_test(10);
        System.out.println("初始测试数据" + Arrays.toString(test));
        selectSort(test);
        System.out.println("选择排序后的数据：" + Arrays.toString(test));

    }
}
