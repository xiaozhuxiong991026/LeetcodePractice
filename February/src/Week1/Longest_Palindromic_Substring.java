package Week1;

/**
 * @Author Aurora_zh
 * @Date 2023/2/8 21:12
 */

/*
* 给你一个字符串 s，找到 s 中最长的回文子串。

如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

 

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
*
*
* */
public class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        //采用中心回文的方法  分别讨论每一次中心点的 奇数回文 和 偶数回文的情况 并返回最大的回文串
        //设置length start end表示最长回文串的长度 开始点 结束点
        int length = 0, start_long = 0, end_long = 0;//这里也可以用一个三元数组实现 int[] long = new int[3]
        int start, end;//记录循环时的动态起始点
        for (int i = 0; i < s.length(); i++) {
            //奇数回文
            start = i;
            end = i;
            while ((start > 0) && (end < s.length() - 1) && s.charAt(start - 1) == s.charAt(end + 1)) {
                //奇回文一定要先 处理end 和 start  因为判断的时候是判断的 start - 1 和 end + 1 ，回文区间是加减过后的
                start--;
                end++;
                if (length < end - start) {
                    start_long = start;
                    end_long = end;
                    length = end - start;
                }
            }

            //偶数回文
            start = i;
            end = i + 1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                //偶回文 一定要先判断区间大小 因为i 和 i+1 本来就有区间了
                if (length < end - start) {
                    start_long = start;
                    end_long = end;
                    length = end - start;
                }
                start--;
                end++;
            }

        }
        return s.substring(start_long, end_long + 1);
    }


    public static void main(String[] args) {
        Longest_Palindromic_Substring Solution = new Longest_Palindromic_Substring();
        String test = "babad";
        System.out.println(Solution.longestPalindrome(test));

    }
}
