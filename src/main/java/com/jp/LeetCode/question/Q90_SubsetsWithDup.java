package com.jp.LeetCode.question;

import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * @author zjp
 * @Description
 * @createTime 20:18
 **/
public class Q90_SubsetsWithDup {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDupCore(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public static void subsetsWithDupCore(int[] nums, int start, List<Integer> track, List<List<Integer>> result) {
        result.add(new ArrayList<>(track));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            track.add(nums[i]);
            subsetsWithDupCore(nums, i+1, track, result);
            track.remove(track.size()-1);
        }
    }

    public static void test(int[] nums){
        List<List<Integer>> result = subsetsWithDup(nums);
        for(List<Integer> r : result){
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 2});
    }
}
