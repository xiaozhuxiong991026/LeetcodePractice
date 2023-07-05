package Week1;

import java.util.Arrays;

/**
 * @Author Aurora_zh
 * @Date 2023/2/9 19:25
 */


/*
* 给你两个字符串 haystack 和 needle
* 请你在 haystack 字符串中找出 needle 字符串的
* 第一个匹配项的下标（下标从 0 开始）
* 如果 needle 不是 haystack 的一部分，则返回  -1 。

 

示例 1：
输入：haystack = "aaacaaab", needle = "aaab"
输出：4
*
示例 2：
输入：haystack = "leetcode", needle = "leeto"
输出：-1
解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。

*KMP 算法解决
*
*
*
* */
public class KMP {
    //实现next数组函数
    public static int[] getNext(String aim_str) {
        int[] next = new int[aim_str.length()];
        next[0] = -1;// 第一个永远为-1
        //如果子串只有1个直接返回
        if (next.length == 1) {
            return next;
        }
        //如果子串有2个以上的字符
        next[1] = 0;//第二个永远为 0
        int i = 2;
        int cn = 0;//记录next[i-1]的值
        while (i < aim_str.length()) {
            //如果子串的 当前字符 与 子串【前一个字符的next值】 相等
            //那么当前字符的next值 就是前一个字符next的+1
            if (aim_str.charAt(i - 1) == aim_str.charAt(cn)) {
                next[i++] = ++cn;
            }
            //如果子串的 当前字符 与 主串【前一个字符的next值】 不相等  且前一个字符的next值大于0
            //那么当前字符的next值 就得回溯cn下一个的next值 一直到回溯到有结果
            else if (cn > 0) {
                cn = next[cn];
            }
            //如果回溯不出结果 那么这个字符的next 就是0
            else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static int strStr(String haystack, String needle) {
        //如果主串为空 或者 子串为空 或者 主串的长度小于字串
        // 则无需匹配 直接返回 匹配失败 -1
        if (haystack.isEmpty() || needle.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }
        //处理目标串  得到它的对称特点
        int x = 0, y = 0;// x指向长串  y指向子串
        int[] next = getNext(needle);
        System.out.println(Arrays.toString(next));
        int count = 0;// 记录比较次数
        //开始遍历 查找
        while (x < haystack.length() && y < needle.length()) {
            count++;
            if (haystack.charAt(x) == needle.charAt(y)) {//如果字符相同 标志就一起前进
                x++;
                y++;
            } else if (next[y] < 0) {
                // 如果不相同 判断是不是第0个元素
                //主串 x 需要前进
                x++;
            } else
                //如果上一次的匹配失败  且y所在的位置有最大前后缀
                //说明这次的匹配失败是有用的   所以要让字串移动 使得子串y之前的前缀和主串对应的y的后缀对齐
                y = next[y];
        }
        System.out.println("比较了" + count + "次");
        return y == needle.length() ? x - y : -1;
    }

    public static int Solution(String haystack, String needle) {
        //没必要匹配的情况
        if (haystack.isEmpty() || needle.isEmpty() || haystack.length() < needle.length()) {
            return -1;
        }


        int x = 0;//指向长串
        int y = 0;//指向子串
        int count = 0;//记录匹配的次数
        while (x < haystack.length() && y < needle.length()) {
           count++;

            if (haystack.charAt(x) == needle.charAt(y)) {
                y++;
                x++;
            } else {
                x = x - y + 1;
                y = 0;//注意 最后改变y的值
            }
        }
        System.out.println("比较了" + count + "次");
        return y == needle.length() ? x - y : -1;
    }
    
    public static void main(String[] args) {
        String test = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String aim =  "aaaaab";
        System.out.println(Solution(test, aim));
        System.out.println("--------------------------------");
        System.out.println(strStr(test, aim));
    }
}
