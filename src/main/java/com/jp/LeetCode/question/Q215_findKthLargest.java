package com.jp.LeetCode.question;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zjp
 * @createTime 2020/7/28 8:34
 **/
public class Q215_findKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return nums[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            if(heap.size() == k){
                if(nums[i] > heap.peek()){
                    heap.poll();
                    heap.add(nums[i]);
                }
            } else {
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }

    public static int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return nums[0];
        }
        int left = 0, right = nums.length-1;
        int targetIndex = len - k;
        while (left <= right){
            int index = partition(nums, left, right);
            if(index == targetIndex){
                return nums[index];
            } else if(index < targetIndex){
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return  -1;
    }

    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        while (left < right){
            while (left < right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void test(int[] nums, int k, int expectded){
        System.out.println(findKthLargest(nums, k) == expectded);
        System.out.println(findKthLargest2(nums, k) == expectded);
        System.out.println("===");
    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        heap.add(1);
//        heap.add(2);
//        System.out.println(heap.peek());
        test(new int[]{3,2,1,5,6,4}, 2, 5);
        test(new int[]{1}, 1, 1);
        test(new int[]{2, 1}, 2, 1);
    }

}
