package com.jp.LeetCode.question;

//Given a string containing digits from 2-9 inclusive,
// return all possible letter combinations that the number could represent.
//
//A mapping of digit to letters (just like on the telephone buttons) is given below.
// Note that 1 does not map to any letters.
//Example:
//
//Input: "23"
//Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//Note:
//
//Although the above answer is in lexicographical order, your answer could be in any order you want.

import java.util.ArrayList;
import java.util.List;

//2:abc
//3:def
//4:ghi
//5:jkl
//6:mno
//7:pqsr
//8:tuv
//9:wxyz
public class Q17_LetterCombinationsofaPhoneNumber {

    //非递归解法
    //初始化排列{""}
    //1、输入2，代表"abc"
    //已有排列中只有字符串""，所以得到{"a","b","c"}
    //2、输入3，代表"def"
    //(1)对于排列中的首元素"a"，删除"a"，并分别加入'd','e','f'，得到{"b","c","ad","ae","af"}
    //(2)对于排列中的首元素"b"，删除"b"，并分别加入'd','e','f'，得到{"c","ad","ae","af","bd","be","bf"}
    //(2)对于排列中的首元素"c"，删除"c"，并分别加入'd','e','f'，得到{"ad","ae","af","bd","be","bf","cd","ce","cf"}
    public static List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length()==0)
            return result;
        List<String> lettersList = new ArrayList<String>();
        for(int i=0;i<digits.length();i++){
            lettersList.add(getLetters(Integer.parseInt(digits.charAt(i)+"")));
        }
        result.add("");
        for(int i=0;i<digits.length();i++){
            int size = result.size();
            String lettets = lettersList.get(i);
            for(int j=0;j<size;j++){
                String cur = result.get(0);
                result.remove(0);
                for(int k=0;k< lettets.length();k++)
                    result.add(cur+lettets.charAt(k));
            }
        }
        return result;
    }

    //递归解法
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length()==0)
            return result;
        List<String> lettersList = new ArrayList<String>();
        for(int i=0;i<digits.length();i++){
            lettersList.add(getLetters(Integer.parseInt(digits.charAt(i)+"")));
        }
        letterCombinationsCore(result,lettersList,"",0,digits.length());
        return result;
    }

    public static void letterCombinationsCore(List<String> result,List<String> lettersList,String tempStr,int index,int len){
        if(index==len-1){
            String letters = lettersList.get(index);
            for(int i=0;i<letters.length();i++){
                result.add(tempStr + letters.charAt(i));
            }
        }else{
            String letters = lettersList.get(index);
            for(int i=0;i<letters.length();i++){
                letterCombinationsCore(result,lettersList,tempStr+letters.charAt(i),index+1,len);
            }
        }
    }

    public static String getLetters(int num){
        String letters;
        switch (num){
            case 2 : letters = "abc"; break;
            case 3 : letters = "def"; break;
            case 4 : letters = "ghi"; break;
            case 5 : letters = "jkl"; break;
            case 6 : letters = "mno"; break;
            case 7 : letters = "pqsr"; break;
            case 8 : letters = "tuv"; break;
            case 9 : letters = "wxyz"; break;
            default: letters = "";
        }
        return letters;
    }

    public static void Test(String digits){
        List<String> result = letterCombinations(digits);
        for(String str : result){
            System.out.println(str);
        }
        System.out.println("===");
    }

    public static void Test2(String digits){
        List<String> result = letterCombinations2(digits);
        for(String str : result){
            System.out.println(str);
        }
        System.out.println("===");
    }

    public static void main(String[] args) {
        Test("23");
        Test("234");
        Test("");
        System.out.println("---------------------");
        Test2("23");
        Test2("234");
        Test2("");
    }
}
