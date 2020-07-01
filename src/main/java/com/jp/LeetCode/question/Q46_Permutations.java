package com.jp.LeetCode.question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//en a collection of distinct integers, return all possible permutations.
//
//Example:
//
//Input: [1,2,3]
//Output:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
public class Q46_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        permuteCore(nums,used,0,new ArrayList<Integer>(),result);
        return result;
    }

    public static void permuteCore(int[] nums,boolean[] used,int index,List<Integer> curr,List<List<Integer>> result){
        if(index==nums.length){
            result.add(new ArrayList<Integer>(curr));
        }else{
            for(int i=0;i<nums.length;i++){
                if(!used[i]){
                    used[i] = true;
                    curr.add(nums[i]);
                    permuteCore(nums,used,index+1,curr,result);
                    curr.remove(curr.size()-1);
                    used[i] = false;
                }
            }
        }
    }

    public static void test(int[] nums){
        List<List<Integer>> result = permute(nums);
        for(List<Integer> l : result){
            System.out.println(l.toString());
        }
        System.out.println("---");
        result = permute2(nums);
        for(List<Integer> l : result){
            System.out.println(l.toString());
        }
        System.out.println("============");
    }

    public static void main(String[] args) {
        test(new int[]{1,2,3});
        test(new int[]{});
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteCore2(nums, 0, new ArrayList<Integer>(), result, new HashSet<>());
        return result;
    }

    public static void permuteCore2(int[] nums, int count, List<Integer> track, List<List<Integer>> result, Set<Integer> set){
        if(count == nums.length){
            result.add(new ArrayList<>(track));
        }else {
            for(int i=0;i<nums.length;i++){
                if(set.contains(i))
                    continue;
                track.add(nums[i]);
                set.add(i);
                permuteCore2(nums, count+1, track, result, set);
                track.remove(track.size()-1);
                set.remove(i);
            }
        }
    }
}
