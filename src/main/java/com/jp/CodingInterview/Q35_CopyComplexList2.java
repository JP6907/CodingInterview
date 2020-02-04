package com.jp.CodingInterview;

// 输入一个复杂链表
// （每个节点中有节点值，以及两个指针，
// 一个指向下一个节点，另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的head。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

public class Q35_CopyComplexList2 {

    public static class RandomListNode{
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label){
            this.label = label;
        }
    }

    public static RandomListNode Clone(RandomListNode pHead){
        if(pHead==null)
            return null;
        CloneNodes(pHead);
        ConnectRandomNodes(pHead);
        RandomListNode cloneHead = SeparateList(pHead);
        return cloneHead;
    }

    //第一步，克隆节点，将克隆的新节点插入在原链表中对应节点的后面
    // 1-1`-2-2`-3-3`-4-4`-...
    public static void CloneNodes(RandomListNode pHead){
        RandomListNode p = pHead;
        while (p!=null){
            RandomListNode cloneNode = new RandomListNode(p.label);
            cloneNode.next = p.next;
            p.next = cloneNode;
            p = cloneNode.next;
        }
    }

    //第二步：连接克隆节点的random指针
    public static void ConnectRandomNodes(RandomListNode pHead){
        RandomListNode p = pHead;
        while (p!=null){
            RandomListNode cloneNode = p.next;
            if(p.random!=null)
                cloneNode.random = p.random.next;
            p = cloneNode.next;
        }
    }

    //第三步：切分链表
    //返回clone链表的头指针
    public static RandomListNode SeparateList(RandomListNode pHead){
        RandomListNode cloneHead = pHead.next;
        RandomListNode p = pHead.next;
        RandomListNode cp = cloneHead;
        while (cp.next!=null){
            p.next = cp.next;
            p = p.next;
            cp.next = p.next;
            cp = cp.next;
        }
        return cloneHead;
    }


    public static RandomListNode CreateList(int[] node){
        assert node.length > 0;
        RandomListNode head = new RandomListNode(node[0]);
        RandomListNode p = head;
        for(int i=1;i<node.length;i++){
            RandomListNode next = new RandomListNode(node[i]);
            p.next = next;
            p = p.next;
        }
        return head;
    }

    public static void PrintList(RandomListNode head){
        RandomListNode p = head;
        while (p!=null){
            System.out.print(p.label);
            if(p.random!=null)
                System.out.format("(%d)",p.random.label);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        int NUMBER = 5;
        RandomListNode[] nodes = new RandomListNode[NUMBER];
        for(int i=0;i<NUMBER;i++)
            nodes[i] = new RandomListNode(i+1);
        for(int i=0;i<NUMBER-1;i++)
            nodes[i].next = nodes[i+1];

        RandomListNode head = nodes[0];

        nodes[0].random = nodes[2];
        nodes[1].random = nodes[4];
        nodes[3].random = nodes[1];

        PrintList(head);
        RandomListNode cloneHead = Clone(head);
        PrintList(cloneHead);
    }
}
