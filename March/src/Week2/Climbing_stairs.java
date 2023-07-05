package Week2;

/**
 * @Author Aurora_zh
 * @Date 2023/3/10 19:57
 */

/*
*
* 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

示例 1：
输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
*
示例 2：
输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶

*
* */
public class Climbing_stairs extends Tools {
    /*
    * 思路
    *递归解决
    * 第n层的结果= （n-1）+ （n-2）   --- 直接函数递归 会超时！
    *
    *
    * */
    public static int climbStairs(int n) {
        //递归结束条件
        if(n ==1) return 1;
        if(n ==2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
    }


    public static int climbStairs1(int n) {
        //递归结束条件
        if(n ==1) return 1;
        if(n ==2) return 2;
        int a = 1, b = 2;
        for(int i = 3; i <= n; i++){
            b = a + b;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        Climbing_stairs time = new Climbing_stairs();
        time.getRuntime();

    }


    @Override
    public void run() {
        //int i = climbStairs(45);
        int i = climbStairs(45);
        System.out.println(i);
    }
}





