package com.jp.LeetCode.question;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

//Given a string, find the length of the longest substring without repeating characters.
//
//Example 1:
//
//Input: "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
public class Q3_LongestSubstringWithoutRepeatingCharacters {

    //滑动窗口
    public static int lengthOfLongestSubstring2(String s) {
        if(s.length()<2)
            return s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0,right=0;
        int longest = 1;
        int cur = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            if(!map.containsKey(c)){
                map.put(c,right);
                if(++cur>longest){
                    longest = cur;
                }
            }else {//出现过
                left = map.get(c)+1;
                cur = right-left+1;
                map.put(c,left);
            }
            right++;
        }
        return longest;
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()<2)
            return s.length();
        //key:字母
        //value：当前窗口中第一次出现的位置
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int left = 0,right = 0;
        int maxLength = Integer.MIN_VALUE;
        int len = 0;
        while (right<s.length()&&left<=right){
            char c = s.charAt(right);
            if(!map.containsKey(c)){
                map.put(c,right);
                right++;
                if(++len>maxLength)
                    maxLength = len;
            }else{
                //出现过，将left移动到第一次出现的下一个位置，同时在map中删除left移动时扫过的字母
                int firstAppear = map.get(c);
                while (left<=firstAppear){
                    map.remove(s.charAt(left++));
                }
                map.put(c,right);
                len = right-left+1;
                right++;
            }
        }
        return maxLength;
    }

    public static void Test(String str,int expected){
        System.out.println(lengthOfLongestSubstring(str)==expected);
        System.out.println(lengthOfLongestSubstring2(str)==expected);
        System.out.println(lengthOfLongestSubstring3(str)==expected);
        System.out.println(lengthOfLongestSubstring4(str)==expected);
    }

    public static void main(String[] args) {
        Test("abcabcbb",3);
        Test("bbbbb",1);
        Test("pwwkew",3);
        Test("au",2);
    }

    public static int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> windows = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            windows.put(c, windows.getOrDefault(c, 0)+1);
            right++;
            while (windows.getOrDefault(c, 0) > 1){
                char lc = s.charAt(left++);
                windows.put(lc, windows.get(lc)-1);
            }
            result = Math.max(result, right-left);
        }
        return result;
    }

    public static int lengthOfLongestSubstring4(String s) {
        int len = s.length();
        if(len < 2){
            return len;
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        while (right < len){
            char c = s.charAt(right++);
            window.merge(c, 1, (oldValue, newValue) -> oldValue + 1);
            while (window.getOrDefault(c, 0) > 1){
                char lc = s.charAt(left++);
                window.put(lc, window.get(lc) - 1);
            }
            result = Math.max(result, right - left);
        }
        return result;
    }

}
