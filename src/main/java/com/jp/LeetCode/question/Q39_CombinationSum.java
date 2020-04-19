package com.jp.LeetCode.question;

//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
// find all unique combinations in candidates where the candidate numbers sums to target.
//The same repeated number may be chosen from candidates unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//Example 1:
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
//Example 2:
//
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]

// DFS
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39_CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combinationDFS(0,candidates,target,new ArrayList<Integer>(),result);
        return result;
    }

    public static void combinationDFS(int start,int[] candidates,int target,List<Integer> list,List<List<Integer>> result){
        if(target<0)
            return;
        if(target==0)
            result.add(new ArrayList<Integer>(list));
        else{
            for(int i=start;i<candidates.length&&candidates[i]<=target;i++){
                list.add(candidates[i]);
                combinationDFS(i,candidates,target-candidates[i],list,result);
                list.remove(list.size()-1);
            }
        }
    }

    public static void Test(int[] candidates, int target){
        List<List<Integer>> result = combinationSum(candidates,target);
        for(List<Integer> list : result){
            System.out.println(list.toString());
        }
        System.out.println("=========");
    }

    public static void main(String[] args) {
        Test(new int[]{2,3,6,7},7);
        Test(new int[]{2,3,5},8);
    }
}
