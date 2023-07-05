package Week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * @Author Aurora_zh
 * @Date 2023/2/23 21:43
 */
/*
*给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。

 

示例 1：

输入：ransomNote = "a", magazine = "b"
输出：false
示例 2：

输入：ransomNote = "aa", magazine = "ab"
输出：false
示例 3：

输入：ransomNote = "aa", magazine = "aab"
输出：true

*
*
*
* */



public class Ransom_Letter {
    //暴力解法
    public static boolean canConstruct1(String ransomNote, String magazine) {
        boolean[] flag = new boolean[magazine.length()];
        boolean result = false;
        for (int i = 0; i < ransomNote.length(); i++) {
            char temp = ransomNote.charAt(i);
            for (int j = 0; j < magazine.length(); j++) {
                if (magazine.charAt(j) == temp && !flag[j]) {
                    result = true;
                    flag[j] = true;
                    break;
                }
                if (j == magazine.length() - 1) {
                    return false;
                }
                result = false;
            }
        }
        return result;
    }

    // 利用哈希 统计杂志中和恐吓信中出现的每个字符个数
    // 如果杂志字符的个数>= 恐吓信字符的个数，说明可以构成
    public static HashMap<Character, Integer> getMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else
                map.put(temp, 1);
        }
        return map;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        HashMap<Character, Integer> map_mag = getMap(magazine);
        HashMap<Character, Integer> map_ran = getMap(ransomNote);
        Set<Character> keySet_ran = map_ran.keySet();
        for (char key : keySet_ran) {
            if (!map_mag.containsKey(key)) {
                return false;
            }
            else if (map_mag.get(key) < map_ran.get(key))
                return false;
        }
        return true;
    }

    // 巧用数组解决问题
    public static boolean canConstruct3(String ransomNote, String magazine){
        int[] word = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            word[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            word[magazine.charAt(i) - 'a']--;
        }
        System.out.println(Arrays.toString(word));
        for (int i = 0; i <26 ; i++) {
            if(word[i] > 0) return false;
        }
        return true;
    }



    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct1(ransomNote, magazine));
        System.out.println(canConstruct2(ransomNote, magazine));
        System.out.println(canConstruct3(ransomNote, magazine));
    }
}
