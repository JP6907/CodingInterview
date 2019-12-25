package com.jp.question;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

// 面试题39：数组中出现次数超过一半的数字
// 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
// 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
// 出现了5次，超过数组长度的一半，因此输出2。
public class Q39_MoreThanHalfNumber {

    static int Partition(int[] data,int low,int high){
        assert low>=0 && high<data.length && low<=high;
        int index = (int)(Math.random()*(high-low)+low);
        int pivot = data[index];
        data[index] = data[low];
        data[low] = pivot;
        while(low<high){
            while(low<high && data[high]>=pivot)
                high--;
            data[low] = data[high];
            while(low<high && data[low]<= pivot)
                low++;
            data[high] = data[low];
        }
        data[low] = pivot;
        return low;
    }

    //方法1：使用快速排序的思想,寻找中位数
    //如果存在一个数出现次数超过一半，则它必定为中位数
    //返回下标，不存在则返回-1
    static int MoreThanHalfNum1(int[] data){
        assert null!=data && data.length>0;
        int low = 0;
        int high = data.length-1;
        int middle = data.length/2;
        int index = Partition(data,low,high);
        while(index!=middle){
            if(index<middle)
                index = Partition(data,index+1,high);
            else
                index = Partition(data,low,index-1);
        }
        int result = data[index];
        if(CheckMoreHalf(data,result))
            return index;
        else
            return -1;
    }

    //方法2：根据数组特点
    //遍历计数，相同+1，不同-1
    static int MoreThanHalfNum2(int[] data){
        assert null!=data && data.length>0;
        int index = 0;
        int result = data[0];
        int count = 1;
        for(int i=1;i<data.length;i++){
            if(count==0){
                index = i;
                result = data[i];
                count = 1;
            }else {
                if (data[i] == result)
                    count++;
                else {
                    count--;
                }
            }
        }
        if(count==0)
            return -1;
        if(CheckMoreHalf(data,result))
            return index;
        else
            return -1;

    }

    static boolean CheckMoreHalf(int[] data,int number){
        int times = 0;
        for(int d:data){
            if(d==number)
                times++;
        }
        if(times*2<=data.length)
            return false;
        else
            return true;
    }

    public static void main(String[] args){
        int[] data = {1,2,3,2,2,2,5,4,2};
        //int[] data = {1,2,3,4,5,6,5,4,2};
        int index = MoreThanHalfNum2(data);
        if(index!=-1)
            System.out.println(data[index]);
        else
            System.out.println("No exist!");
    }
}
