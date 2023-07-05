package Week1;

import java.util.*;

/**
 * @Author Aurora_zh
 * @Date 2023/2/9 14:38
 */


/*翻转字符串里的单词
给你一个字符串 s ，请你反转字符串中 单词 的顺序。

单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。

返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。

注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

 

示例 1：

输入：s = "the sky is blue"
输出："blue is sky the"
示例 2：

输入：s = "  hello world  "
输出："world hello"
解释：反转后的字符串中不能存在前导空格和尾随空格。
*
*
*
*
* */
//思路：
// 1. 利用空格找到所有的单词   记录空格的位置 截取相邻空格的字符串即为单词
// 2.每找到一个单词就压入栈中
// 3.string为空时 依次出栈直到栈空


public class Reback_word {
/*    //独自完成的方法 时间复杂度和空间复杂度都较高
    public String reverseWords(String s) {
        Stack<String> words = new Stack<>();//单词栈
        String result = "";//结果字符串
        s= s.trim();//处理两头的空格
        //处理中间的空格
        while (s.contains(" ")) {
            words.push((s.substring(0, s.indexOf(' ') + 1).trim()));
            s = s.substring(s.indexOf(' ') + 1, s.length());
        }
        //压入最后一个不以空格结尾的单词
        words.push(s);
        while (!words.isEmpty()) {
            if (!words.peek().equals(""))
                result += words.pop() + " ";
            else words.pop();
        }
        result = result.trim();
        return result;*/
//参考答案 时间复杂度和空间复杂度都较低 优
/*    public String reverseWords(String s) {
        s = s.trim();//清除开头和结尾的空格
        int len = s.length();
        while (len-- > 0) {
            //如果最后一个字符为空格
            if (s.charAt(len) == ' ') {
                String word = s.substring(len + 1, s.length());
                return word + " " + reverseWords(s.substring(0, len));
            }
        }
        return s;
    }*/

    public String reverseWords(String s) {
        Stack<String> words = new Stack<>();//单词栈
        String result = "";//结果字符串
        for (String word : s.split(" ")) {
            if (!word.equals("")) {
                words.push(word);
            }
        }
        while (!words.empty())
            result += words.pop() + " ";
        result = result.trim();
        return result;


    }

    public static void main(String[] args) {
        String test = "a good   example";
        Reback_word Solution = new Reback_word();
        System.out.println(Solution.reverseWords(test));

    }
}
