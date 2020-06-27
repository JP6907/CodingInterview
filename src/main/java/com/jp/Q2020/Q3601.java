package com.jp.Q2020;

import java.util.Scanner;

public class Q3601 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dna1 = sc.next();
        String dna2 = sc.next();
        int aCnt=0,tCnt=0;
        for(int i=0;i<dna1.length();i++){
            if(dna1.charAt(i)!=dna2.charAt(i)){
                if(dna2.charAt(i)=='A')
                    aCnt++;
                else
                    tCnt++;
            }
        }
        if(aCnt<tCnt){
            int tmp = aCnt;
            aCnt = tCnt;
            tCnt = tmp;
        }
        int count = aCnt-tCnt;
        count += (aCnt-count);
        System.out.println(count);

    }
}
