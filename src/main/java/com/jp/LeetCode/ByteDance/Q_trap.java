package com.jp.LeetCode.ByteDance;

import com.sun.javafx.collections.ChangeHelper;
import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author shangqiu
 * @createTime 2020/7/23
 **/
public class Q_trap {

    public static int trap(int[] height) {
        int n = height.length;
        if(n < 2){
            return 0;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(height[i], left[i-1]);
        }
        right[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(height[i], right[i+1]);
        }
        int result = 0;
        for(int i=1;i<n-1;i++){
            int min = Math.min(left[i-1], right[i+1]);
            if(min > height[i]){
                result += min - height[i];
            }
        }
        return result;
    }

    public static int trap2(int[] height) {
        int n = height.length;
        if(n < 2){
            return 0;
        }
        int l_max = 0, r_max = 0;
        int left = 1, right = n - 2;
        int ans = 0;
        while (left <= right){
            l_max = Math.max(l_max, height[left-1]);
            r_max = Math.max(r_max, height[right+1]);
            if(l_max < r_max){
                int diff = l_max - height[left];
                ans += diff > 0 ? diff : 0;
                left++;
            } else {
                int diff = r_max - height[right];
                ans += diff > 0 ? diff : 0;
                right--;
            }
        }
        return ans;
    }

    public static void test(int[] height, int expected){
        System.out.println(trap(height) == expected);
        System.out.println(trap2(height) == expected);
    }

    public static void main(String[] args) {
        test(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6);
    }

}
