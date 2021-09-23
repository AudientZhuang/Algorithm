package com.audient._24;

import java.util.List;

public class FirstSolution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        //ListNode node3 = new ListNode(3);
        //ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = null;
        //node2.next = node3;
        //node3.next = node4;
        ListNode listNode = swapPairs(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        // 两两交换
        // 1. 只有0个或1个节点，直接返回head
        // 2. 有2个或2个以上节点，需要进行交换

        if(head == null || head.next == null) {
            return head;
        }

        // 交换节点，用来遍历各个节点
        ListNode tempNode;
        // 头节点，不含值
        ListNode firstNode = new ListNode();
        firstNode.next = head;
        tempNode = firstNode;

        while (tempNode.next != null && tempNode.next.next != null) {

            ListNode node1 = tempNode.next;
            ListNode node2 = tempNode.next.next;

            tempNode.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            tempNode = node1;

        }



        return firstNode.next;


    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
