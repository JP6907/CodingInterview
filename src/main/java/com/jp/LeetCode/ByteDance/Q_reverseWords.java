package com.jp.LeetCode.ByteDance;

/**
 * @author zjp
 * @createTime 2020/7/21 23:46
 **/
public class Q_reverseWords {

    public static String reverseWords(String s) {
        char[] chars = s.trim().toCharArray();
        //翻转非空格
        int left = 0, right = 0;
        while (right < chars.length){
            if(chars[right] != ' '){
                right++;
            }
            if(right == chars.length || chars[right] == ' '){
                reverse(chars, left, right-1);
                while (right < chars.length && chars[right] == ' '){
                    right++;
                }
                left = right;
            }
        }
        //全部翻转
        reverse(chars, 0, chars.length-1);

        //去除中间多余的空格
        int slow = 0, fast = 0;
        while (fast < chars.length){
            if(chars[fast] != ' ' || chars[fast-1] != ' '){
                chars[slow++] = chars[fast];
            }
            fast++;
        }
        return new String(chars, 0, slow);
    }

    public static void reverse(char[] array, int left, int right){
        while (left < right){
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static void test(String s, String expected){
        String result = reverseWords(s);
        System.out.println(result);
        System.out.println(result.equals(expected));
    }

    public static void main(String[] args) {
        test("the sky is blue", "blue is sky the");
        test("  hello world!  ", "world! hello");
        test("a good   example", "example good a");
    }
}
