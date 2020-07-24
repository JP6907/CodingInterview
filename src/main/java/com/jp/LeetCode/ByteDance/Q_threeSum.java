package com.jp.LeetCode.ByteDance;

import org.omg.PortableInterceptor.INACTIVE;
import sun.nio.cs.ext.IBM037;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shangqiu
 * @createTime 2020/7/22
 **/
public class Q_threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length < 3){
            return result;
        }
        for(int i=0;i<nums.length;i++){
            List<ArrayList<Integer>> tuples = twoSum(nums, i+1, 0-nums[i]);
            for(List<Integer> tuple : tuples){
                tuple.add(nums[i]);
                result.add(tuple);
            }
            while (i < nums.length-1 && nums[i] == nums[i+1])
                i++;
        }
        return result;
    }

    public static List<ArrayList<Integer>> twoSum(int[] nums, int start, int target){
        List<ArrayList<Integer>> result = new ArrayList<>();
        if(nums.length - start < 2){
            return result;
        }
        int low = start, high = nums.length - 1;
        while (low < high){
            int sum = nums[low] + nums[high];
            int left = nums[low];
            int right = nums[high];
            if(sum == target){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[low]);
                list.add(nums[high]);
                result.add(list);
                while (low < high && nums[low] == left){
                    low++;
                }
                while (low < high && nums[high] == right){
                    high--;
                }
            } else if(sum < target){
                while (low < high && nums[low] == left){
                    low++;
                }
            } else {
                while (low < high && nums[high] == right){
                    high--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> nSum(int[] nums, int n, int start, int target){
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if(n < 2 || len < n){
            return result;
        }
        if(n == 2){
            int low = start, high = nums.length - 1;
            while (low < high){
                int sum = nums[low] + nums[high];
                int left = nums[low];
                int right = nums[high];
                if(sum == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[low]);
                    list.add(nums[high]);
                    result.add(list);
                    while (low < high && nums[low] == left){
                        low++;
                    }
                    while (low < high && nums[high] == right){
                        high--;
                    }
                } else if(sum < target){
                    while (low < high && nums[low] == left){
                        low++;
                    }
                } else {
                    while (low < high && nums[high] == right){
                        high--;
                    }
                }
            }
        } else {
            for(int i=start;i<len;i++){
                List<List<Integer>> sub = nSum(nums, n-1, i+1, target-nums[i]);
                for(List<Integer> list : sub){
                    list.add(nums[i]);
                    result.add(list);
                }
                while (i<len-1 && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
        return result;
    }

    public static void test(int[] nums){
        List<List<Integer>> result = threeSum(nums);
        for(List<Integer> r : result){
            System.out.println(Arrays.toString(r.toArray()));
        }
        System.out.println("---");
        result = nSum(nums, 3, 0, 0);
        for(List<Integer> r : result){
            System.out.println(Arrays.toString(r.toArray()));
        }
        System.out.println("===");
    }

    public static void main(String[] args) {
        test(new int[]{-1, 0, 1, 2, -1, -4});
        //-2 -1 0 1 2 3
        //[[-2,-1,3],[-2,0,2],[-1,0,1]]
        test(new int[]{3,0,-2,-1,1,2});
    }

}
