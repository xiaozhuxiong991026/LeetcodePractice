package Week2;

/**
 * @Author Aurora_zh
 * @Date 2023/2/15 17:26
 */

/*买卖股票的最佳时机
给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票
并选择在 未来的某一个不同的日子 卖出该股票
设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润
如果你不能获取任何利润，返回 0 。



示例 1：

输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入
在第 5 天（股票价格 = 6）的时候卖出
最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6,
     因为卖出价格需要大于买入价格
     同时，你不能在买入前卖出股票。
示例 2：

输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
*  思路：
1. 暴力解法 //超时
 public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j <prices.length ; j++) {
                max = Math.max(max,prices[j]-prices[i]);
            }
        }
        return max;
    }
*2.动态规划
记录【今天之前买入的最小值】
计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
比较【每天的最大获利】，取最大值即可
*
* */
public class Buy_Sell_Stocks {
    public static int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = {1, 2};
        System.out.println(maxProfit(test));
    }
}
