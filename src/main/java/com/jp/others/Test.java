package com.jp.others;

public class Test {

    public static void main(String[] args) {
        //System.out.println(3|2);

        int a = 2;
        int b = 3;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);

        System.out.println(reverse("abcdef"));
    }

    public static String reverse(String str){
        char[] chars = str.toCharArray();
        int left=0,right=str.length()-1;
        while (left<right){
            chars[left] = (char) (chars[left]^chars[right]);
            chars[right] = (char) (chars[left]^chars[right]);
            chars[left] = (char) (chars[left]^chars[right]);
            left++;
            right--;
        }
        return new String(chars);
    }
}
