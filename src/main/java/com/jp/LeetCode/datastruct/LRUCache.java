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

    public int get(int key){
        return 0;
    }

    public void put(int key, int val){

    }

    private class Node{
        private int key;
        private String val;

        public Node(int key, String val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public String getVal() {
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
