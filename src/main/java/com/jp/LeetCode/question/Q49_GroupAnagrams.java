package com.jp.LeetCode.question;

//Given an array of strings, group anagrams together.
//
//Example:
//
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
//Note:
//
//All inputs will be in lowercase.
//The order of your output does not matter.

import java.util.*;

public class Q49_GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for(int i=0;i<strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            if(!map.containsKey(key)){
                List<String> valueList = new ArrayList<String>();
                valueList.add(strs[i]);
                map.put(key,valueList);
            }else {
                map.get(key).add(strs[i]);
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(List<String> value : map.values()){
            result.add(value);
        }
        return result;
    }

    public static void test(String[] strs){
        List<List<String>> result = groupAnagrams(strs);
        for(List<String> list : result){
            System.out.println(list.toString());
        }
    }

    public static void main(String[] args) {
        test(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
