package com.jp.question;


// 面试题35：复杂链表的复制
// 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复
// 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
// 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
public class Q35_CopyComplexList {

    public static class ComplexListNode<T>{
        T value;
        ComplexListNode<T> next;  //指向下一个节点
        ComplexListNode<T> sibling; //指向任意一个节点，可以是null

        public ComplexListNode(T value) {
            this.value = value;
            this.next = null;
            this.sibling = null;
        }
    }

    //第一步，克隆节点，将克隆的新节点插入在原链表中对应节点的后面
    // 1-1`-2-2`-3-3`-4-4`-...
    public static void CloneNodes(ComplexListNode<Integer> pHead){
        if(pHead==null)
            return;
        ComplexListNode<Integer> node = pHead;
        while (node!=null){
            ComplexListNode<Integer> cloneNode = new ComplexListNode<Integer>(node.value);
            cloneNode.next = node.next;
            node.next = cloneNode;
            node = cloneNode.next;
        }
    }

    //第二步：连接克隆节点的sibling指针
    public static void ConnectSiblingNodes(ComplexListNode<Integer> pHead){
        if(pHead==null)
            return;
        ComplexListNode<Integer> node = pHead;
        while (node!=null){
            ComplexListNode<Integer> cloneNode = node.next;
            if(node.sibling!=null){
                cloneNode.sibling = node.sibling.next;
            }
            node = cloneNode.next;
        }
    }

    //第三步：切分链表
    //返回clone链表的头指针
    public static ComplexListNode<Integer> ReconnectetNodes(ComplexListNode<Integer> pHead){
        if(pHead==null)
            return null;
        ComplexListNode<Integer> cloneHead = pHead.next;
        ComplexListNode<Integer> cloneNode = cloneHead;
        ComplexListNode<Integer> nextNode = pHead;
        nextNode.next = cloneNode.next;
        nextNode = nextNode.next;
        //1     1`        2     2`    3   3` ...
        //      ^         ^
        //      |         |
        //  cloneNode nextNode
        while(nextNode!=null){
            cloneNode.next = nextNode.next;
            cloneNode = cloneNode.next;
            nextNode = cloneNode.next;
        }
        return cloneHead;
    }

    public static ComplexListNode Clone(ComplexListNode<Integer> pHead){
        CloneNodes(pHead);
        ConnectSiblingNodes(pHead);
        return ReconnectetNodes(pHead);
    }

    public static void PrintComplexList(ComplexListNode<Integer> pHead){
        StringBuffer sb = new StringBuffer("ComplexList: ");
        ComplexListNode<Integer> node = pHead;
        while (node!=null){
            sb.append(node.value);
            if(node.sibling!=null){
                sb.append("(" + node.sibling.value + ")");
            }
            sb.append(" ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args){
        ComplexListNode<Integer> node1 = new ComplexListNode<Integer>(1);
        ComplexListNode<Integer> node2 = new ComplexListNode<Integer>(2);
        ComplexListNode<Integer> node3 = new ComplexListNode<Integer>(3);
        ComplexListNode<Integer> node4 = new ComplexListNode<Integer>(4);
        ComplexListNode<Integer> node5 = new ComplexListNode<Integer>(5);
        ComplexListNode<Integer> node6 = new ComplexListNode<Integer>(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node2.sibling = node4;
        node3.sibling = node1;
        node5.sibling = node6;
        PrintComplexList(node1);

        ComplexListNode<Integer> cloneHead = Clone(node1);
        PrintComplexList(cloneHead);
    }
}
