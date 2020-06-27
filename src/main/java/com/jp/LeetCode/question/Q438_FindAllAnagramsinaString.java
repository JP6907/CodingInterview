package com.jp.LeetCode.question;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 找到字符串中所有字母异位词
 * @author zjp
 * @createTime 2020/6/26 10:04
 **/
public class Q438_FindAllAnagramsinaString {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> windows = new HashMap<>();
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0)+1);
        }
        int left = 0, right = 0;
        int match = 0;
        List<Integer> result = new ArrayList<>();
        while (right < s.length()){
            char c = s.charAt(right++);
            windows.put(c, windows.getOrDefault(c, 0)+1);
            if(windows.get(c).equals(needs.get(c))){
                match++;
            }
            while (match == needs.size()){
                if(right-left==p.length()){
                    result.add(left);
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
        return result;
    }

    public void test(String s,String p, List<Integer> expected){
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result.containsAll(expected));
    }

    public static void main(String[] args) {
        Q438_FindAllAnagramsinaString qtest = new Q438_FindAllAnagramsinaString();
        qtest.test("cbaebabacd", "abc", Arrays.asList(0, 6));
    }

}
