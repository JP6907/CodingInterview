package com.jp.Q2020;

import java.util.Scanner;

public class NiukeWang2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String pattern = sc.next();
        boolean result = match(str,pattern);
        if(result)
            System.out.println("true");
        else
            System.out.println("false");
    }

    //*：匹配0个或以上的字符（字符由英文字母和数字0-9组成，不区分大小写。下同）
    //？：匹配1个字符
    public static boolean match(String str,String pattern){
        return matchCore(str,0,pattern,0);
    }

    public static boolean matchCore(String str,int indexStr,String pattern,int indexPattern) {
            if (indexStr >= str.length() && indexPattern >= pattern.length())
            return true;
        if (indexStr >= str.length() || indexPattern >= pattern.length())
            return false;
        if (pattern.charAt(indexPattern) == '?' || pattern.charAt(indexPattern) == str.charAt(indexStr))
            return matchCore(str, indexStr + 1, pattern, indexPattern + 1);
        else if (pattern.charAt(indexPattern) == '*') {
            return matchCore(str, indexStr, pattern, indexPattern + 1) //0个
                    || matchCore(str, indexStr + 1, pattern, indexPattern + 1) //1个
                    || matchCore(str, indexStr+1, pattern, indexPattern); //多个
        } else {
            return false;
        }
    }

}
