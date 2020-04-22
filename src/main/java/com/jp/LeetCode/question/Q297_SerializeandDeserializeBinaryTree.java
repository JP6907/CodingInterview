package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q297_SerializeandDeserializeBinaryTree {

    //前序遍历
    //null节点:#!
    //非null节点：val!
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root==null)
            return "#,";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val+",");
        sb.append(serialize(root.left)).append(serialize(root.right));
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        index = 0;
        return deserializeCore(data.split(","));
    }

    static int index = 0;
    // Decodes your encoded data to tree.
    public static TreeNode deserializeCore(String[] data) {
        if(index>=data.length){
            return null;
        }
        TreeNode root = null;
        String val = data[index++];
        if(!val.equals("#")){
            root = new TreeNode(Integer.parseInt(val));
            root.left = deserializeCore(data);
            root.right = deserializeCore(data);
        }
        return root;
    }

    //层次遍历
    public static String serialize2(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null)
            return result.toString();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            if(p!=null){
                queue.offer(p.left);
                queue.offer(p.right);
                result.append(p.val+",");
            }else {
                result.append("#,");
            }
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public static TreeNode deserialize2(String data) {
        if(data.length()==0)
            return null;
        String[] fields = data.split(",");
        if(fields.length==0)
            return null;
        TreeNode[] nodes = new TreeNode[fields.length];
        for(int i=0;i<fields.length;i++){
            if(!fields[i].equals("#")) {
                nodes[i] = new TreeNode(Integer.parseInt(fields[i]));
            }else {
                nodes[i] = null;
            }
        }
        int child = 1;
        for(int i=0;i<fields.length;i++){
            if(nodes[i]!=null){
                nodes[i].left = nodes[child++];
                nodes[i].right = nodes[child++];
            }
        }
        return nodes[0];
    }


    public static void main(String[] args) {
        TreeNode node345 = new TreeNode(3,4,5);
        TreeNode root = new TreeNode(1,new TreeNode(2),node345);
        String result = serialize2(root);
        TreeNode root2 = deserialize2("");
    }
}
