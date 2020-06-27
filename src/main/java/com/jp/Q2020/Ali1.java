package com.jp.Q2020;

import java.util.Scanner;

public class Ali1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        int indexS=0,indexT=0;
        while (indexS<S.length()&&indexT<T.length()){
            if(S.charAt(indexS)==T.charAt(indexT)){
                indexT++;
            }
            indexS++;
        }
        int diff = (T.length()-indexT);
        System.out.println(diff);
    }
}
