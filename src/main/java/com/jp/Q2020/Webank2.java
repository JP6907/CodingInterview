package com.jp.Q2020;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Webank2 {
    //如果总长度是偶数：所有字符的出现次数都是偶数
    //如果总长度是奇数：只有一个字符是出现一次，其它字符都出现次数是偶数
    //最终结果：最多有一个字符的数量是奇数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String str = sc.next();
            Map<Character,Integer> map = new HashMap<>();
            for(int j=0;j<str.length();j++){
                char c = str.charAt(j);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else {
                    map.put(c,1);
                }
            }
            Collection<Integer> values = map.values();
            int oddCount = 0;
            for(Integer count : values){
                if(count%2==1)
                    oddCount++;
            }
            System.out.println(oddCount%2==0?"Eleanore":"Cassidy");
        }

    }
}
