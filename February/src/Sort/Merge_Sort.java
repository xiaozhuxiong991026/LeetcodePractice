package Sort;
import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/11 14:11
 */

/*
 * 归并排序
 *
 * 利用递归：
 * 1.将原数组分为若干小数组
 * 2.继续划分小数组  直到小数组只有1个值
 * 3.比较小数组值的大小  排序
 * 4.将排序好的小数组归并回去 就得到了排序好的原数组
 *
 *
 *
 *
 * */
public class Merge_Sort {
    //先将原数组类似二分查找  分为左右2部分 直到左右2部分都只剩一个数据
    //然后只需要比较2个小数组元素的大小合成新的数组
    //层层退回  到原数组就是排序好的数组
    public static void mergeSort(int[] arr, int left, int right) {
        //递归结束的条件是 ：小数组的左界 >= 右界
        if (left >= right) {
            return;
        }
        //递归划分
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        //划分结束后 开始合并
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];//创建临时数组 存储排序的结果
        while (i <= mid && j <= right)// 如果左右2个小数组都还有数据
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];//将较小的顺序放入临时数组
        //从上面的循环出来说明 左右最少有一个数组已经遍历完了
        while (i <= mid)//左边的数组还有的话  依次顺序放入临时数组

            temp[k++] = arr[i++];

        while (j <= right)//右边的数组还有数据的话 依次顺序放入临时数组
            temp[k++] = arr[j++];

        for (int m = 0; m < temp.length; m++)//将排好序的临时数组 放回对应的原数组的位置
            arr[left + m] = temp[m];
        System.out.println(Arrays.toString(temp));
    }



    public static void main(String[] args) {
        Get_test get_test = new Get_test();
        int test[] = get_test.get_test(8);
        System.out.println(Arrays.toString(test));
        mergeSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }
}
