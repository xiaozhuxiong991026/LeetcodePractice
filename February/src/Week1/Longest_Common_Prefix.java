package Week1;

/**
 * @Author Aurora_zh
 * @Date 2023/2/8 18:01
 */

//思路都在注释里了


public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        String result;
        String minStr = strs[0];
        //先确定最短的字符串，因为结果肯定小于等于这个minStr
        for (String str : strs) {
            if (str.length() < minStr.length()) {
                minStr = str;
            }
        }
        //依次从后缩短minStr的长度  比较是否匹配
        for (int i = minStr.length(); i > 0; i--) {
            result = minStr.substring(0, i);
            int count = 0;//记录匹配成功的个数
            for (String str : strs) {
                if(!result.equals(str.substring(0, i))) {
                    break;
                }
                count++;
            }
            //如果此次截取的minStr可与全部匹配
            if (count == strs.length) {
                return result;
            }
        }
        //minStr全部截取完都没有返回结果 说明没有匹配的  返回空串
        return "";
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        Longest_Common_Prefix solution = new Longest_Common_Prefix();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}
