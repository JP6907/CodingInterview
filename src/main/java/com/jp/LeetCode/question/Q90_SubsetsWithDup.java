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
        Set<List<Integer>> set = new TreeSet<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.containsAll(o2) && o2.containsAll(o1)){
                    return 0;
                }else {
                    return new Random().nextInt(10)>=5?1:-1;
                }
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDupCore(nums, 0, new ArrayList<>(), result, set);
        return result;
    }

    public static void subsetsWithDupCore(int[] nums, int start, List<Integer> track, List<List<Integer>> result, Set<List<Integer>> set) {
        if(!set.contains(track)) {
            List<Integer> temp = new ArrayList<>(track);
            result.add(temp);
            set.add(temp);
        }
        for(int i=start;i<nums.length;i++){
            track.add(nums[i]);
            subsetsWithDupCore(nums, i+1, track, result, set);
            track.remove(track.size()-1);
        }
    }

    public static boolean ListEqual(List<Integer> list1, List<Integer> list2){
        return list1.containsAll(list2) && list2.containsAll(list1);
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
