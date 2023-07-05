package test;
import java.util.Arrays;
/**
 * @Author Aurora_zh
 * @Date 2023/2/8 9:18
 */
public class TestArrays {
    public static void main(String[] args) {
        /*
        void Array.sort(Object[] array)
        功能：对数组按照升序排序
        */
        int[] nums = {2,5,0,4,6,-10};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        /* 之前:2 5 0 4 6 -10
         * 结果:-10 0 2 4 5 6
         */

        /*
        Arrays.sort(Object[] array, int from, int to)
        功能：对数组元素指定范围进行排序（排序范围是从元素下标为from,到下标为to-1的元素进行排序）
        */
        //对前四位元素进行排序
        //Arrays.sort(num1, 0, 4);
       /* for(int i :num1)
            System.out.print(i+" ");*/
        /* 之前:2 5 0 4 1 -10
         * 结果:0 2 4 5 1 -10
         */
        System.out.println(Arrays.binarySearch(nums, 0));


    }

}
