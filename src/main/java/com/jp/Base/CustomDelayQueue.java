package com.jp.Base;


import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义延迟消息队列
 * 基于DelayQueue
 */
public class CustomDelayQueue {
    //消息编号
    static AtomicInteger MESSAGEENO = new AtomicInteger();

    public static void main(String[] args){
        DelayQueue<DelayedElement> delayQueue = new DelayQueue<>();
        producer(delayQueue,"生产者1");
        producer(delayQueue,"生产者2");
        consumer(delayQueue);
    }

    //生产者
    public static void producer(DelayQueue<DelayedElement> delayQueue,String name){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    long time = 1000L * (new Random().nextInt(5)+1);
                    try {
                        Thread.sleep(time);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    String message = String.format("%s，消息编号：%s 发送时间：%s 延迟：%s 秒\n",
                            name,MESSAGEENO.getAndIncrement(),DateFormat.getDateTimeInstance().format(new Date()),time/1000);
                    //生产消息
                    delayQueue.put(new DelayedElement(message,time));
                }
            }
        }).start();
    }

    public static void consumer(DelayQueue<DelayedElement> delayQueue){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    DelayedElement element = null;
                    try {
                        element = delayQueue.take();
                        System.out.println(element);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //延迟队列对象
    static class DelayedElement implements Delayed{
        //过期时间
        long time = System.currentTimeMillis();
        //消息体
        String message;

        public DelayedElement(String message,long delayTime){
            this.time += delayTime;
            this.message = message;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if(this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS))
                return 1;
            else if(this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS))
                return -1;
            else
                return 0;
        }

        @Override
        public String toString() {
            return message + " |执行时间：" + DateFormat.getDateTimeInstance().format(new Date());
        }
    }
}
