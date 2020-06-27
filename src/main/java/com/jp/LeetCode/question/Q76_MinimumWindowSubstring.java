package com.jp.LeetCode.question;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjp
 * @createTime 2020/6/26 9:27
 **/
public class Q76_MinimumWindowSubstring {

    Map<Character,Integer> needs = new HashMap<>();
    Map<Character,Integer> windows = new HashMap<>();

    public String minWindow(String s, String t) {
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c,0)+1);
        }
        int left = 0, right = 0;
        int match = 0;
        int resultLeft = 0;
        int resultRight = 0;
        int resultLen = Integer.MAX_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0)+1);
            if(windows.get(c).equals(needs.get(c))){
                match++;
            }
            right++;
            while (match == needs.size()){
                int len = right - left + 1;
                if(len < resultLen){
                    resultLen = len;
                    resultLeft = left;
                    resultRight = right;   //前面right已经自增了，所以结果是[resultLeft,resultRight)
                }
                char lc = s.charAt(left++);
                if(needs.containsKey(lc)){
                    windows.put(lc, windows.get(lc)-1);
                    if(windows.get(lc) < needs.get(lc)){
                        match--;
                    }
                }
            }
        }
        return s.substring(resultLeft, resultRight);
    }

    public void test(String s, String t, String expected){
        System.out.println(minWindow(s,t).equals(expected));
    }

    public static void main(String[] args) {
        Q76_MinimumWindowSubstring qtest = new Q76_MinimumWindowSubstring();
        qtest.test("ADOBECODEBANC", "ABC", "BANC");
    }

}
