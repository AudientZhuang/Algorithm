package com.audient._19;

import java.util.List;

public class FirstSolution {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        ListNode listNode = removeNthFromEnd(listNode1, 5);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode left = head;

        // 计算出链表的长度
        int len = 0;
        while (left != null) {
            len++;
            left = left.next;
        }

        // 删除的是头结点，直接把第二个节点设置为头结点
        if (len == n) {
            head = head.next;
            return head;
        }

        // 找到对应位置的节点，删除
        left = head;
        int index = -1;
        while (left != null) {
            index++;
            if (index == len - n - 1) {
                left.next = left.next.next;
            }
            left = left.next;
        }
        return head;
    }



    static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
