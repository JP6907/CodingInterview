package com.jp.LeetCode.question;

import java.util.LinkedList;
import java.util.Queue;

public class Q116_PopulatingNextRightPointersinEachNode {

    //层次遍历
    public Node connect(Node root) {
        if(root==null)
            return null;
        Queue<Node> queue = new LinkedList<Node>();
        Node node = root;
        Node pre = null;
        queue.offer(node);
        int curCount = 1;
        int nextCount = 0;
        while (!queue.isEmpty()){
            node = queue.poll();
            if(node.left!=null) {
                queue.offer(node.left);
                nextCount++;
            }
            if(node.right!=null) {
                queue.offer(node.right);
                nextCount++;
            }

            if(pre==null) {
                pre = node;
            }else {
                pre.next = node;
                pre = node;
            }
            if(--curCount==0){
                curCount = nextCount;
                nextCount = 0;
                pre = null;
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
