package Week2;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/16 19:47
 */

/*
*合并两个有序的数组，使得合并后的数组仍然有序，要求算法时间复杂度为o(n)例如:
int[] arr1 = 1, 3,5, 7, 9;
int[] arr2 = 2, 4, 5, 8, 9, 10;合并后:
t1, 2, 3, 4,5,5, 7, 8, 9, 9, 10
*
*
* */
public class Hainiu_Homework01 {
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];//合并后的结果数组
        int index1 = 0,index2 = 0;// 双指针分别指向arr1和arr2的起始位置
        int i = 0;//结果数组的指针
        while(index1 < arr1.length && index2 < arr2.length){
            result[i++] = arr1[index1] < arr2[index2]? arr1[index1++] : arr2[index2++];
        }
        // 如果arr1或者arr2的指针还没有到结尾 一次加入余下的result
        while(index1 < arr1.length){
            result[i++] = arr1[index1++];
        }
        while(index2 < arr2.length){
            result[i++] = arr2[index2++];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5, 7, 9};
        int[] arr2 = new int[]{2, 4, 5, 8, 9, 10};
        System.out.println(Arrays.toString(merge(arr1, arr2)));
    }


}
