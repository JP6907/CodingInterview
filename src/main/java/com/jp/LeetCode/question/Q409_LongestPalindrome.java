package com.jp.LeetCode.question;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zjp
 * @createTime 2020/7/12 17:58
 **/
public class Q409_LongestPalindrome {

    public static int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int result = 0;
        boolean flag = false;
        Collection<Integer> values = map.values();
        for(int value : values){
            if(value % 2 == 0){
                result += value;
            }else {
                if(!flag){
                    result += value;
                    flag = true;
                }else {
                    result += value-1;
                }
            }
        }
        return result;
    }

    public static void test(String s, int expected){
        System.out.println(longestPalindrome(s) == expected);
    }

    public static void main(String[] args) {
        test("abccccdd", 7);
        test("ccc", 3);
    }

}
