package com.jp.LeetCode.question;

//Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.
// The guards have gone and will come back in H hours.
//
//Koko can decide her bananas-per-hour eating speed of K.
// Each hour, she chooses some pile of bananas, and eats K bananas from that pile.
// If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
//
//Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
//
//Return the minimum integer K such that she can eat all the bananas within H hours.
//
//Example 1:
//
//Input: piles = [3,6,7,11], H = 8
//Output: 4
//Example 2:
//
//Input: piles = [30,11,23,4,20], H = 5
//Output: 30
//Example 3:
//
//Input: piles = [30,11,23,4,20], H = 6
//Output: 23
//
//
//Note:
//
//1 <= piles.length <= 10^4
//piles.length <= H <= 10^9
//1 <= piles[i] <= 10^9


// 每小时最多吃一堆香蕉，如果吃不下的话留到下一小时再吃；如果吃完了这一堆还有胃口，也只会等到下一小时才会吃下一堆。
// 每小时吃一堆，最多吃K个，如果堆里少于K个，不继续吃下去
// 确定吃香蕉的最小速度
// 最大速度为最大那堆香蕉的数量
// 速度从0到1，分别测试能否吃完
// 这是一个在连续空间中线性搜索的问题，可以使用二分法
// 搜索左侧边界的二分法
public class Q875_KokoEatingBananas {

    //暴力
    public static int minEatingSpeed(int[] piles, int H) {
        int maxSpeed = getMaxSpeed(piles);
        for(int speed = 1;speed<=maxSpeed;speed++){
            if(canFinish(piles,H,speed))
                return speed;
        }
        return maxSpeed;
    }

    //二分法
    public static int minEatingSpeed2(int[] piles, int H) {
        int maxSpeed = getMaxSpeed(piles);
        int left =1,right = maxSpeed;
        while (left<=right){
            int mid = (left+right)/2;
            if(canFinish(piles,H,mid))
                right = mid-1;
            else
                left = mid+1;
        }
        return left;
    }

    public static boolean canFinish(int[] piles,int H,int speed){
        int time = 0;
        for(int pile : piles){
            time += (pile/speed + (pile%speed==0?0:1));
        }
        return time <= H;
    }

    public static int getMaxSpeed(int[] piles){
        int max = 0;
        for(int pile : piles){
            max = Math.max(max,pile);
        }
        return max;
    }

    public static void test(int[] piles,int H,int expected){
        System.out.println(minEatingSpeed(piles,H)==expected);
        System.out.println(minEatingSpeed2(piles,H)==expected);
        System.out.println(minEatingSpeed3(piles,H)==expected);
        System.out.println("====");
    }

    public static void main(String[] args) {
        test(new int[]{3,6,7,11},8,4);
        test(new int[]{30,11,23,4,20},5,30);
        test(new int[]{30,11,23,4,20},6,23);
    }


    //二分查找，寻找符合条件的左边界
    public static int minEatingSpeed3(int[] piles, int H) {
        int left = 1, right = getMaxSpeed3(piles);
        while (left < right){
            int mid = left + (right-left)/2;
            if(canFinish3(piles, mid, H)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }


    public static boolean canFinish3(int[] piles, int speed, int maxTime){
        int time = 0;
        for(int pile : piles){
            time += timeOf3(pile, speed);
        }
        return time <= maxTime;
    }

    public static int timeOf3(int pile, int speed){
        int div = pile/speed;
        if(pile%speed==0){
            return div;
        }else {
            return div+1;
        }
    }

    //每次最多只能吃一堆，速度再高没有意义
    public static int getMaxSpeed3(int[] piles){
        int max = 1;
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        return max;
    }
}
