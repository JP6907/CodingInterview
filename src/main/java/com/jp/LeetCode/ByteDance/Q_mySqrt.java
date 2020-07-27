package com.jp.LeetCode.ByteDance;

/**
 * @author zjp
 * @createTime 2020/7/26 10:17
 **/
public class Q_mySqrt {

    public static int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int left = 0, right = x;
        int ans = -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if((long)mid * mid <= x){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void test(int x, int expected){
        System.out.println(mySqrt(x) == expected);
    }

    public static void main(String[] args) {
        test(4, 2);
        test(8, 2);
        test(2147395599, 46339);
    }
}
