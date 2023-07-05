package Sort;

import java.util.Arrays;
import java.util.Random;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * @Author Aurora_zh
 * @Date 2023/2/10 11:44
 */

/*
 * 冒泡排序：
 *把第一个元素与第二个元素比较，如果第一个比第二个大
 * 则交换他们的位置。接着继续比较第二个与第三个元素，如果第二个比第三个大，则交换他们的位置....
 * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对，这样一趟比较交换下来之后，排在最右的元素就会是最大的数。
 *
 * */
public class Bubble_sort {
    /*冒泡排序：
     *把第一个元素与第二个元素比较，如果第一个比第二个大，则交换他们的位置。
     * 接着继续比较第二个与第三个元素，如果第二个比第三个大，则交换他们的位置....
     * 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对
     * 这样一趟比较交换下来之后  排在最右的元素就会是最大的数。*/
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }

    /* 冒泡算法的优化：
      假如从开始的第一对到结尾的最后一对，相邻的元素之间都没有发生交换的操作，
      这意味着右边的元素总是大于等于左边的元素，此时的数组已经是有序的了
      我们无需再对剩余的元素重复比较下去了。*/
    public static void bubbleSort_better(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;//每次比较之前设置一个flag
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;// 一旦发生了交换 flag = false
                }
            }
            if (flag) {
                break;//如果flag有变化 --> 没有发生交换 --> i之后的已经是排列好的，所以无需再继续后面的比较
            }
        }
    }



    public static void main(String[] args) {
        Get_test get = new Get_test();
        int[] test1 = get.get_test(10);//test1 用于测试 基本 的冒泡排序
        int[] test2 = get.get_test(10);//test2 用于测试 优化 的冒泡排序
        int[] test3 = get.get_test(10);//test3 用于测试 递归实现 的冒泡排序
        System.out.println("基本算法 初始：" + Arrays.toString(test1));
        bubbleSort(test1);
        System.out.println("冒泡排序：" + Arrays.toString(test1));

        System.out.println("优化算法 初始：" + Arrays.toString(test2));
        bubbleSort_better(test2);
        System.out.println("冒泡排序优化：" + Arrays.toString(test2));

    }


}
