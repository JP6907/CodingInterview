package com.jp.LeetCode.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 * @author zjp
 * @Description
 * @createTime 8:57
 **/
public class Q77_Combine {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineCore(n, k, 1, result, new ArrayList<>());
        return result;
    }

    public static void combineCore(int n, int k, int start, List<List<Integer>> result, List<Integer> track){
        if(k==0){
            result.add(new ArrayList<>(track));
        }else {
            for (int i=start;i<=n;i++){
                track.add(i);
                combineCore(n, k-1, i+1, result, track);
                track.remove(track.size()-1);
            }
        }
    }

    public static void test(int n, int k){
        List<List<Integer>> result = combine(n, k);
        for(List<Integer> r : result){
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static void main(String[] args) {
        test(4, 2);
    }

}
