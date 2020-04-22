package com.jp.LeetCode.question;

import com.jp.LeetCode.datastruct.TreeNode;

public class Q450_DeleteNodeinaBST {

    //1.左右子节点为空，直接删除
    //2.只有一个子节点，子节点代替
    //3.左右子节点都在，在右子树中寻找中序遍历的下一个节点(直接后继节点)来代替
    //   用直接后继节点来代替时需要用到被删除节点的父节点
    //   则只需要替换被删除节点的val就好，不需要真的删除该节点，然后再删除直接后继节点
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return root;
        if(root.val<key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val>key) {
            root.left = deleteNode(root.left, key);
        }else {
            if(root.left==null&&root.right==null){
                root = null;
            }else if(root.left==null) {
                root = root.right;
            }else if(root.right==null){
                root = root.left;
            }else {
                TreeNode rMin = minNode(root.right);
                root.val = rMin.val;
                root.right = deleteNode(root.right,rMin.val);
            }
        }
        return root;
    }

    //寻找最小的节点
    public TreeNode minNode(TreeNode root){
        if(root==null)
            return null;
        TreeNode p = root;
        while (p.left!=null)
            p = p.left;
        return p;
    }

}
