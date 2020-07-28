package com.jp.LeetCode.question;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zjp
 * @createTime 2020/7/28 8:34
 **/
public class Q215_findKthLargest {

    public int findKthLargest(int[] nums, int k) {
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

    public int findKthLargest2(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        while (left < right){
            int index = partition(nums, left, right);
            if(index == k-1){
                return nums[index];
            } else if(index < k-1){
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return  -1;
    }

    public int partition(int[] nums, int left, int right){
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

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);
        heap.add(2);
        System.out.println(heap.peek());
    }

}
