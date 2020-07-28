package com.jp.LeetCode.datastruct;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author zjp
 * @createTime 2020/7/28 8:12
 **/
public class LRUCache2 {

    public int capacity;
    public Map<Integer, Node> map;
    public LinkedList<Node> cache;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new LinkedList<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        } else {
            int val = map.get(key).value;
            put(key, val);
            return val;
        }
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(map.containsKey(key)){
            cache.remove(map.get(key));
            map.remove(key);
            cache.addFirst(node);
            map.put(key, node);
        } else {
            if(cache.size() == capacity){
                Node last = cache.getLast();
                map.remove(last.key);
                cache.removeLast();
            }
            cache.addFirst(node);
            map.put(key, node);
        }
    }

    public static class Node{
        public int key;
        public int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
