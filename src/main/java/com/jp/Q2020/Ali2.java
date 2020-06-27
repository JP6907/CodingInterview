package com.jp.Q2020;

import java.lang.reflect.Array;
import java.util.*;

public class Ali2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] L = new int[n];
        int[] R = new int[n];
        for(int i=0;i<n;i++){
            L[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            R[i] = sc.nextInt();
        }
        double expected = 0.0;
        int lMax = Integer.MIN_VALUE;
        int rMax = Integer.MIN_VALUE;

        Set<Integer> minList = new HashSet<>();
        for(int i=0;i<n;i++){
            if(!minList.contains(L[i]))
                minList.add(L[i]);
            lMax = Math.max(lMax,L[i]);
            rMax = Math.max(rMax,R[i]);
        }
        for(int min=lMax+1;min<=rMax;min++){
            if(!minList.contains(min))
                minList.add(min);
        }
        for(Integer min : minList){
            double prob = 0.0;
            for(int i=0;i<n;i++){
                if(min>=L[i]&&min<=R[i]){
                    if(prob==0.0)
                        prob = 1/((double)(R[i]-L[i]+1));
                    else
                        prob += 1/((double)(R[i]-L[i]+1));
                }
            }
            expected += min*prob;
        }
        System.out.format("%.8f",expected);

//        for(int i=0;i<n;i++){
//            double prob = 1/((double)(R[i]-L[i]+1));
//            for(int j=0;j<n;j++){
//                if(i!=j){
//                    //L[i] 在 L[j]到R[j]区间内
//                    if(L[i]<=R[j]&&L[i]>=L[j]){
//                        prob += ((R[j]-L[i]+1)/((double)(R[j]-L[j]+1)));
//                    }
//                }
//            }
//            expected += (L[i]*prob);
//            lMax = Math.max(lMax,L[i]);
//            rMax = Math.max(rMax,R[i]);
//        }
//        for(int min=lMax+1;min<=rMax;min++){
//            double prob = 0.0;
//            for(int i=0;i<n;i++){
//                if(min<=R[i]){
//                    if(prob==0.0)
//                        prob = (1/((double)(R[i]-L[i]+1)));
//                    else
//                        prob *= (1/((double)(R[i]-L[i]+1)));
//                }
//            }
//            expected += min*prob;
//        }
//        //System.out.println(expected);
//        System.out.format("%.8f",expected);
    }
}
