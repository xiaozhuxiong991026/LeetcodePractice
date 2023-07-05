package Week2;

/**
 * @Author Aurora_zh
 * @Date 2023/2/16 19:56
 */
/*
*
* 给定一个正整教m (m >= 10)，现在想去掉这个数的n位 （0<n<m的位数，例如m=9527，是一个四位数，则n可取的值为1-3)
* 但保持该整数每位上的数字相对顺序不变，使得剩余的数字组成的数是最大值。例如:
m = 51342，n = 1;则结果应该是去掉数字1，剩余的值最大，为5342;
m = 51342，n = 2;则结果应该是去掉数字1、3，剩余的值最大，为542:
m = 51342，n = 3; 则结果应该是去掉数字1、3、2，剩余的值最大，为54
请使用Java语言编程，实现该算法。其中的m和n按要求输入正确范围内的数字即可，无需做合法校验。程序执行效果如下:
请输入一个正整数《至少要两位数) :51342
请输入要去掉的数字个数:
3
剩余最大值为: 54
*
* */
public class Hainiu_Homework02 {
    //思路
    // 去掉n个数的结果 = 去掉n-1的数的基础上再去掉一个
    // f(m,n) = f ( f(m,n-1),1 )


    public static int Solution2(int m, int n) {
        Solution2(Solution2(m,n-1),1);
        if(n==0){
            return m;
        }
        if(n==1){
             m = Solution1(m);
        }
        return m;
    }

    public static int Solution(int m, int n) {
        for (int i = 0; i < n; i++) {
             m = Solution1(m);
        }
        return m;
    }
    //m去掉一位剩下的最大数
    public static int Solution1(int m) {
        //方向 找到最小值的位数 然后去除掉即可
        String num_str = String.valueOf(m);//转化为字符串
        int[] num = new int[num_str.length()];//原数字的数组形式
        for(int i = 0; i < num_str.length(); i++){
            num[i] = num_str.charAt(i) - '0';
        }
        int min = num[0];//最小值
        int index = 0;//记录最小值的位数
        for(int i = 0; i < num.length; i++){
            if(num[i] < min){
                min = num[i];
                index = i;
            }
        }
        long result = 0;
        for (int i = 0; i <num.length ; i++) {
            if(i < index){
                result += num[i] * Math.pow(10,num.length - i - 2);
            }
            if(i > index){
                result += num[i] * Math.pow(10,num.length- i - 1);
            }
        }

       return (int)result;
    }

    public static void main(String[] args) {
        int m = 51342;
        int n = 3;

        System.out.println(Solution(m, n));
    }
}