package com.jp.Q2020;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class XieCheng2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int maxLife = sc.nextInt();
        ArrayList<Integer> lifes = new ArrayList<>();
        for(int i=0;i<count;i++)
            lifes.add(0);
        int birthCount = sc.nextInt();
        int[] birthYear = new int[birthCount];
        for(int i=0;i<birthCount;i++)
            birthYear[i] = sc.nextInt();
        int x = sc.nextInt();
        Arrays.sort(birthYear);
        while (x>0){
            //模拟一年一年增长
            x--;
            ArrayList<Integer> newLife = new ArrayList<>();
            for(int i=0;i<lifes.size();i++){
                for(int j=0;j<birthYear.length;j++){
                    if(lifes.get(i).equals(birthYear[j]-1)){
                        newLife.add(0);
                        break;
                    }
                }
                if(lifes.get(i)<=maxLife)
                    newLife.add(lifes.get(i)+1);
            }
            lifes = newLife;
        }
        System.out.println(lifes.size());
    }
}
