package Week1;

/**
 * @Author Aurora_zh
 * @Date 2023/2/10 9:25
 */

/*
*反转字符串
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

 

示例 1：

输入：s = ["h","e","l","l","o"]
输出：["o","l","l","e","h"]
示例 2：

输入：s = ["H","a","n","n","a","h"]
输出：["h","a","n","n","a","H"]
*
*
*
* */
public class Invert_String {
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        char temp;
        while (head < tail) {
            temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            head++;
            tail--;
        }
    }

    public static void main(String[] args) {

        char[] test = {'h', 'e', 'l', 'l', 'o'};
        Invert_String Solution = new Invert_String();
        Solution.reverseString(test);
        System.out.println(String.valueOf(test));

    }

}


