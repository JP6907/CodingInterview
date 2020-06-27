package com.jp.Tencent2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Tencent20185 {

    //200 * xi + 3 * yi
    //时间的权重最大
    //优先按照时间安排
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int MechineCount = sc.nextInt();
        int TaskCount = sc.nextInt();
        Integer[][] mechines = new Integer[MechineCount][2]; //最大工作时间，机器等级
        Integer[][] tasks = new Integer[TaskCount][2]; //完成时间，任务难度
        for(int i=0;i<MechineCount;i++){
            mechines[i][0] = sc.nextInt();
            mechines[i][1] = sc.nextInt();
        }
        for(int i=0;i<TaskCount;i++){
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
        }
        //对每个任务，寻找最低等级，最低完成时间
        //先根据等级排序，再根据时间
        Arrays.sort(mechines, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[1]-o2[1]==0)
                    return o1[0]-o2[0];
                else
                    return o1[1]-o2[1];
            }
        });
        Arrays.sort(tasks, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[1]-o2[1]==0)
                    return o2[0]-o1[0];
                else
                    return o1[1]-o2[1];
            }
        });
        int count = 0;
        int index = 0;
        int sum = 0;
        boolean[] flag = new boolean[MechineCount];
        for(int taskIndex=0;taskIndex<TaskCount;taskIndex++){
            int mechineIndex = index;
            //寻找最低适合难度
            while (mechineIndex<MechineCount && mechines[mechineIndex][1]<tasks[taskIndex][1])
                mechineIndex++;
            index = mechineIndex;
            //寻找最低适合时间
            while (mechineIndex<MechineCount &&
                    (mechines[mechineIndex][0]<tasks[taskIndex][0] || flag[mechineIndex]==true)) {
                mechineIndex++;
            }

            if(mechineIndex>=MechineCount)
                break;
            count++;
            //收益
            sum += (200*tasks[taskIndex][0] + 3*tasks[taskIndex][1]);
            flag[mechineIndex] = true;
        }

        System.out.format("%d %d\n",count,sum);
    }
}
