package Week1;

import java.util.*;

/**
 * @Author Aurora_zh
 * @Date 2023/2/7 14:12
 */
/*判断回文数
原数模10得到最后一位
原数除10得到剩下的数字*/

public class Palindrome_Number {
    /* public boolean isPalindrome(int x) {
         if (x < 0)
             return false;
         int rem = 0, y = 0;
         int quo = x;
         while (quo != 0) {
             rem = quo % 10;
             y = y * 10 + rem;
             quo = quo / 10;
         }
         return y == x;
     }*/
    public void isPalindrome(int x) {
        if (x < 0)
            System.out.println(false);;
        int temp = 0;
        int x_temp = x;
        int x1 = 0;
        while (x_temp != 0) {
            temp = x_temp % 10;
            x1 = x1 * 10 + temp;
            x_temp = x_temp / 10;
            System.out.println(x1);
        }
        System.out.println("反转后的数为"+x1);
        System.out.println("结果为："+(x1 == x));


    }

    ;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("判断是否为回文数");
        int Num = s.nextInt();
        Palindrome_Number p = new Palindrome_Number();
        p.isPalindrome(Num);
        s.close();
    }

    ;
}