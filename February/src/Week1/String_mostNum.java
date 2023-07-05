package Week1;
import java.util.Scanner;

/**
 * @Author Aurora_zh
 * @Date 2023/2/7 14:51
 */

/*

最长不重复string
* */
public class String_mostNum {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++)
        {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }


    ;





    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 100; i++) {
            String str = s.next();
            String_mostNum p = new String_mostNum();
            System.out.println(p.lengthOfLongestSubstring(str));
        }
        s.close();
    }

}
