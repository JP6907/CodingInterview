package com.jp.LeetCode.ByteDance;

/**
 * @author zjp
 * @createTime 2020/7/21 22:21
 **/
public class Q_longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0){
            return "";
        }
        int[] len = new int[strs.length];
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            len[i] = strs[i].length();
            minLen = Math.min(minLen, len[i]);
        }
        int curr = 0;
        boolean same = true;
        while (same && curr < minLen){
            for(int i=0;i<n-1;i++){
                if(strs[i].charAt(curr) != strs[i+1].charAt(curr)){
                    same = false;
                    break;
                }
            }
            if(same) {
                curr++;
            }
        }
        return curr==0?"":strs[0].substring(0, curr);
    }

    public static void test(String[] strs, String expected){
        String result = longestCommonPrefix(strs);
        System.out.println(result);
        System.out.println(result.equals(expected));
        System.out.println("=======");
    }

    public static void main(String[] args) {
        test(new String[]{"flower","flow","flight"}, "fl");
        test(new String[]{"dog","racecar","car"}, "");
    }
}
