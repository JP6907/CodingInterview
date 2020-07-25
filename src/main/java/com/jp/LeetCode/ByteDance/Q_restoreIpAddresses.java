package com.jp.LeetCode.ByteDance;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shangqiu
 * @createTime 2020/7/22
 **/
public class Q_restoreIpAddresses {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        restoreIpAddresses(s, 0, "", 0, result);
        return result;
    }

    //0-255
    public static void restoreIpAddresses(String s, int index, String curr, int count, List<String> result){
        if(count == 3 && index < s.length() - 3){
            return;
        }
        if(index == s.length() && count == 4){
            result.add(curr.substring(1));
        }
        if(index < s.length() && count < 4){
            String str = s.substring(index, index + 1);
            restoreIpAddresses(s, index + 1, curr + "." + str, count + 1, result);
            if(index < s.length() - 1 && s.charAt(index) != '0'){
                str = s.substring(index, index + 2);
                restoreIpAddresses(s, index + 2, curr + "." + str, count + 1, result);
            }
            if(index < s.length() - 2 && s.charAt(index) != '0'){
                str = s.substring(index, index + 3);
                int num3 = Integer.parseInt(str);
                if(num3 < 256){
                    restoreIpAddresses(s, index + 3, curr + "." + str, count + 1, result);
                }
            }
        }

    }

    public static void test(String s, List<String> expected){
        List<String> result = restoreIpAddresses(s);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void main(String[] args) {
        test("25525511135", Arrays.asList("255.255.11.135", "255.255.111.35"));
        //"0.10.0.10","0.100.1.0"
        // 0.10.0.10,0.100.1.0,
        test("010010", null);
    }

}
