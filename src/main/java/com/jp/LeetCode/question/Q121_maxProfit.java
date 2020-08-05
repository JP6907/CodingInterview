package com.jp.LeetCode.question;

/**
 * @author shangqiu
 * @createTime 2020/7/31
 **/
public class Q121_maxProfit {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int maxPro = 0;
        int minPrice = prices[0];
        for(int i=1;i<len;i++){
            minPrice = Math.min(minPrice, prices[i]);
            maxPro = Math.max(maxPro, prices[i]-minPrice);
        }
        return maxPro;
    }

}
