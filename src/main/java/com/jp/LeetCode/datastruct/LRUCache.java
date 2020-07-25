package com.jp.LeetCode.datastruct;

import java.util.*;

/**
 * LRU 缓存
 * @author zjp
 * @Description
 * @createTime 9:28
 **/
public class LRUCache {

    private LinkedList<Node> cache;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        } else {
            int val = map.get(key).val;
            //数据提前
            put(key, val);
            return val;
        }
    }

    public void put(int key, int val){
        Node node = new Node(key, val);
        //节点是否存在
        //不存在，是否已满
        if(map.containsKey(key)){
            //删除旧节点，新节点插入头部
            cache.remove(map.get(key));
            map.remove(key);
            cache.addFirst(node);
            map.put(key, node);
        } else {
            //满了，删除尾部节点，新节点插入头部
            if(cache.size() == capacity) {
                Node last = cache.getLast();
                map.remove(last.getKey());
                cache.remove(last);
            }
            map.put(key, node);
            cache.addFirst(node);
        }

    }

    private class Node{
        private int key;
        private int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key &&
                    Objects.equals(val, node.val);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, val);
        }
    }
}
