package Week1;

import java.util.ArrayList;

/**
 * @Author Aurora_zh
 * @Date 2023/3/1 19:08
 */

/*
*给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
示例 1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
*
示例 2:
*
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
*
示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*
* */
public class Longest_substring {
    public static void main(String[] args) {
        String test = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(test));

    }

    /*
     *思路：
     * 双指针遍历 中间的串是无重复串
     * 如果新加入的元素在串中已经存在 记录长度 刷新串
     * */
    public static int lengthOfLongestSubstring(String s) {
            // 记录字符上一次出现的位置
        int[] last = new int[26];
        for (int i = 0; i < 26; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index-'a'] + 1);
            res = Math.max(res, i - start + 1);
            last[index-'a'] = i;
        }
        return res;
    }
}


