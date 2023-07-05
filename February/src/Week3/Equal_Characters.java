package Week3;

import java.util.*;

/**
 * @Author Aurora_zh
 * @Date 2023/2/25 19:30
 */

/*
*给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

示例 1:
输入: s = "anagram", t = "nagaram"
输出: true
*
示例 2:
输入: s = "rat", t = "car"
输出: false*
*
* */
public class Equal_Characters {
    //哈希map解决
    public static HashMap<Character, Integer> GetMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }

        }
        return map;
    }

    public static boolean isAnagram_hasmap(String s, String t) {
        //Hasmap解决
        HashMap<Character, Integer> map1 = GetMap(s);
        HashMap<Character, Integer> map2 = GetMap(t);
        //遍历比较同一个字符在2个map中的value是否相等
        if (map1.size() != map2.size()) {
            return false;
        } else {
            for (Character key : map1.keySet()) {
                if (!map1.get(key).equals(map2.get(key))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        //数组巧妙解决
        int[] result = new int[26];
        //统计s中每个字符出现的次数
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
        }
        //除去t中每个字符出现的次数
        for (int i = 0; i < t.length(); i++) {
            result[t.charAt(i) - 'a']--;
        }
        for (Integer i: result) {
            if ( i != 0 )
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String test1 = "abcdefghijklmnopqrstuvwxyz";
        String test2 = "aabc";
        System.out.println(isAnagram_hasmap(test1, test2));
        System.out.println(isAnagram(test1, test2));
    }
}
