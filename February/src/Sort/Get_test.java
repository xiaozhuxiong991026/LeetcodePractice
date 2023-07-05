package Sort;

import java.util.Random;

/**
 * @Author Aurora_zh
 * @Date 2023/2/10 16:24
 */
public class Get_test {
    //获取10个随机数作为测试
    public int[] get_test(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;

    }


}
