package com.jp.Q2020;

import java.util.Scanner;

//AC100
public class XieCheng3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dirts = {"surprise", "happy", "ctrip", "travel", "wellcome","student","system","program","editor"};
        while (sc.hasNext()){
            String str = sc.next();
            System.out.println(correct(str,dirts));
        }

    }

    public static String correct(String str,String[] dirts){
        for(String dirt : dirts){
            if(correctCore(str,0,dirt,0,2))
                return dirt;
        }
        return "null";
    }

    public static boolean correctCore(String str,int indexStr, String dirt,int indexDirt,int times){
        if(times<0)
            return false;
        if(indexStr==str.length()&&indexDirt==dirt.length())
            return true;
        if(indexStr>str.length()||indexDirt>dirt.length())
            return false;
        while (indexStr<str.length()&&indexDirt<dirt.length()&&str.charAt(indexStr)==dirt.charAt(indexDirt)){
            indexStr++;
            indexDirt++;
        }
        if(indexStr==str.length()&&indexDirt==dirt.length())
            return true;
        return correctCore(str,indexStr+1,dirt,indexDirt+1,times-1)
                || correctCore(str,indexStr+1,dirt,indexDirt,times-1)
                || correctCore(str,indexStr,dirt,indexDirt+1,times-1);
    }
}
