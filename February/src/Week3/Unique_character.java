package Week3;

import java.util.HashMap;

/**
 * @Author Aurora_zh
 * @Date 2023/2/20 14:44
 */

/*
* 字符串中的第一个唯一字符
给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
示例 1：
输入: s = "leetcode"
输出: 0
*
示例 2:
输入: s = "loveleetcode"
输出: 2
*
示例 3:
输入: s = "aabb"
输出: -1

*
*
* */
public class Unique_character {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            //hashMap.containsKey(temp) ? hashMap.put(temp, hashMap.get(temp) + 1) : hashMap.put(temp, 1);
            hashMap.put(temp, hashMap.containsKey(temp) ? hashMap.get(temp) + 1 : 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }


    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }


}
