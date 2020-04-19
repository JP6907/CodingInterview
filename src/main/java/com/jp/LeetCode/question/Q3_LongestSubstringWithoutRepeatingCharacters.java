package com.jp.LeetCode.question;

import java.util.HashMap;
import java.util.Map;

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
    }

    public static void main(String[] args) {
        Test("abcabcbb",3);
        Test("bbbbb",1);
        Test("pwwkew",3);
        Test("au",2);
    }
}
