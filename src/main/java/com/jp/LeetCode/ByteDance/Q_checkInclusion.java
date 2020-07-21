package com.jp.LeetCode.ByteDance;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zjp
 * @createTime 2020/7/21 22:34
 **/
public class Q_checkInclusion {

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> target = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char c = s1.charAt(i);
            target.put(c, target.getOrDefault(c, 0)+1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int match = 0;
        while (right < s2.length()){
            char c = s2.charAt(right);
            window.put(c, window.getOrDefault(c, 0)+1);
            if(window.get(c).equals(target.get(c))){
                match++;
            }
            right++;
            while (match == target.size()){
                boolean flag = true;
                for(Character key : window.keySet()){
                    if(!target.getOrDefault(key, 0).equals(window.getOrDefault(key, 0))){
                        flag = false;
                    }
                }
                if(flag) {
                    return true;
                }

                char c2 = s2.charAt(left++);
                window.put(c2, window.get(c2)-1);
                if(window.get(c2) < target.getOrDefault(c2, 0)){
                    match--;
                }
            }
        }
        return false;
    }

    public static void test(String s1, String s2, boolean expected){
        System.out.println(checkInclusion(s1, s2) == expected);
    }

    public static void main(String[] args) {
        test("ab", "eidbaooo", true);
        test("ab", "eidboaoo", false);
        test("hello", "ooolleoooleh", false);
    }

}
