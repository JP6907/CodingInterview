package com.jp.LeetCode.ByteDance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjp
 * @createTime 2020/7/21 22:07
 **/
public class Q_lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){
            return s.length();
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int result = 1;
        while (right < s.length()){
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0)+1);
            while (left < right && window.get(c) > 1){
                char c2 = s.charAt(left);
                window.put(c2, window.get(c2)-1);
                left++;
            }
            right++;
            int diff = right - left;
            result = Math.max(result, diff);
        }
        return result;
    }

    public static void test(String s, int expected){
        System.out.println(lengthOfLongestSubstring(s) == expected);
    }

    public static void main(String[] args) {
        test("abcabcbb", 3);
        test("bbbbb", 1);
        test("pwwkew", 3);
    }
}
