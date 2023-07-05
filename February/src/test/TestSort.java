package test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author Aurora_zh
 * @Date 2023/2/11 9:11
 */
public class TestSort {
    //获取测试数据
    public static int[] Get_test(int n) {
        int[] result = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            result[i] = rand.nextInt(n);
        }
        return result;
    }

    //判断数组为空或者长度为0
    public static void NullOrEmpty_test(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        NullOrEmpty_test(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;//每次冒泡前设置一个标志位
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;//如果冒泡过程中发生了交换 则说明前几位还没有排好序  所以破坏标志位
                }
            }
            if (flag) {
                break;//如果某次的冒泡 标志位没有破坏 说明此次冒泡过程中没有发生交换 已经是有序的  所以无需继续下一个冒泡
            }
        }
    }


    //选择排序
    public static void selectSort(int[] arr) {
        NullOrEmpty_test(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            //假设第i个位置是目前最小的
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    //将i与i之后的数据进行比较 如果比i小就交换
                }
            }
        }
    }


    //插入排序
    public static void insertSort(int[] arr) {
        NullOrEmpty_test(arr);
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];//将i处的值 拿着与i之前的有序序列进行比对插入
            int j;
            for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
                //依次比较temp与i之前的数据
                //temp比arr[j]大的话 说明temp一定比之前的都大 无需继续for
                //所以只有temp比arr[j]小 才会进入for循环
                //小的话就后移一位  腾出位置准备给temp
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;//temp放入腾出的位置 因为出for循环之前会进行依次j--
        }
    }


    public static void main(String[] args) {
        System.out.println("测试 冒泡排序");
        int[] test1 = Get_test(5);
        System.out.println(Arrays.toString(test1));
        bubbleSort(test1);//测试冒泡排序
        System.out.println(Arrays.toString(test1));
        System.out.println("-----------------");


        System.out.println("测试 选择排序");
        int[] test2 = Get_test(10);
        System.out.println(Arrays.toString(test2));
        selectSort(test2);//测试选择排序
        System.out.println(Arrays.toString(test2));
        System.out.println("-----------------");


        System.out.println("测试 插入排序");
        int[] test3 = Get_test(8);
        System.out.println(Arrays.toString(test3));
        insertSort(test3);//测试插入排序
        System.out.println(Arrays.toString(test3));
        System.out.println("-----------------");


    }

}
