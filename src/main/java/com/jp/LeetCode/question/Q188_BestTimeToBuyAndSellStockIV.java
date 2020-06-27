package com.jp.LeetCode.question;

/**
 * @author zjp
 * @createTime 2020/6/21 10:04
 **/
//给定一个数组，它的第i个元素是一支给定的股票在第i天的价格。
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k笔交易。
//注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//示例：
//输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，
//在第 2 天 (股票价格 = 4) 的时候卖出，
//这笔交易所能获得利润 = 4-2 = 2 。
public class Q188_BestTimeToBuyAndSellStockIV {

    //动态规划思路
    //f(n)表示通过n天的买卖获得的最大利润
    //这种表示方法无法获得状态转移方程，故需要添加状态
    //由于有交易次数限制，因此需要有一个状态表示当前可以执行的交易次数
    //由于不能同时参与多笔交易，因此需要有一个状态表示当前是否持有股票
    //f(n)(k)(0) 表示前n天的交易后，剩余交易次数为k，当前未持有股票时获得的最大利润
    //f(n)(k)(1) 表示前n天的交易后，剩余交易次数为k，当前持有股票时获得的最大利润
    //当股票卖出的时候才认为一次交易完成，即k减1
    //状态转移：
    //f(n)(k)(0) = max{前一天未持有股票，前一天持有股票+今天卖出}
    //           = max{f(n-1)(k)(0),f(n-1)(k+1)(1)+prices[n]}
    //f(n)(k)(1) = max{前一天未持有股票+今天买入，前一天持有股票+今天不卖出}
    //           = max{f(n-1)(k)(0)-price[n],f(n-1)(k)(1)}
    //初始状态：
    //f(0)(k)(0) = 0
    //f(0)(i)(1) = -price[0]
    //结果：
    //  f(n)(0)(0)
    //这种方法如果n和k非常大，则可能超出内存限制
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n==0)
            return 0;
        int[][][] f = new int[n][k+2][2];
        for(int i=0;i<n;i++){
            //超出k的状态不存在
            f[i][k+1][1] = Integer.MIN_VALUE;
        }
        for(int j=0;j<=k;j++){
            f[0][j][0] = 0;
            f[0][j][1] = -prices[0];
        }
        for(int i=1;i<n;i++){
            for(int j=k;j>=0;j--) {
                f[i][j][0] = Math.max(f[i - 1][j][0], f[i - 1][j + 1][1] + prices[i]);
                f[i][j][1] = Math.max(f[i - 1][j][0] - prices[i], f[i - 1][j][1]);
            }
        }
        return f[n-1][0][0];
    }

    public static int maxProfit11(int k,int[] prices){
        //f[n][k][0] = max{f[n-1][k][0],f[n-1][k+1][1]+prices[n]}
        //f[n][k][1] = max{f[n-1][k][1],f[n-1][k][0]-prices[n])}
        int n = prices.length;
        int[][][] f = new int[n][k+2][2];
        for(int i=0;i<n;i++){
            f[i][k+1][1] = Integer.MIN_VALUE;
        }
        for(int i=0;i<=k;i++) {
            f[0][i][0] = 0;
            f[0][i][1] = -prices[0];
        }
        for(int i=1;i<n;i++){
            for(int j=k;j>=0;j--){
                f[i][j][0] = Math.max(f[i-1][j][0], f[i-1][j+1][1]+prices[i]);
                f[i][j][1] = Math.max(f[i-1][j][0]-prices[i], f[i-1][j][1]);
            }
        }
        return f[n-1][0][0];
    }

    //优化
    //如果k>总天数/2，则相当于买卖不受k限制了，问题转化为Q122_BestTimeToBuyAndSellStockII

    public static int maxProfit2(int k, int[] prices) {
        int n = prices.length;
        if(n==0)
            return 0;

        if(k>n/2){
            int result = 0;
            for(int i=1;i<n;i++){
                if(prices[i]>prices[i-1])
                    result += (prices[i]-prices[i-1]);
            }
            return result;
        }else {
            return maxProfit11(k, prices);
        }
    }

    public static void test(int k,int[] prices,int expected){
        System.out.println(maxProfit(k,prices)==expected);
        System.out.println(maxProfit2(k,prices)==expected);
    }

    public static void main(String[] args) {
        test(2,new int[]{2,4,1},2);
        test(2,new int[]{3,2,6,5,0,3},7);
    }

}

