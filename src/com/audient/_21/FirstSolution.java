package com.audient._21;

public class FirstSolution {

    public static void main(String[] args) {

        ListNode listNode1_1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(2);
        ListNode listNode1_3 = new ListNode(4);

        ListNode listNode2_1 = new ListNode(1);
        ListNode listNode2_2 = new ListNode(3);
        ListNode listNode2_3 = new ListNode(4);

        listNode1_1.next = listNode1_2;
        listNode1_2.next = listNode1_3;
        listNode1_3.next = null;

        listNode2_1.next = listNode2_2;
        listNode2_2.next = listNode2_3;
        listNode2_3.next = null;

        ListNode listNode = mergeTwoLists(listNode1_1, listNode2_1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head;
        // l1为空
        if (l1 == null) {
            return l2;
        }

        // l2为空
        if (l2 == null) {
            return l1;
        }

        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode listNode = head;   // 记录头结点
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                listNode.next = l1;
                l1 = l1.next;
            } else {
                listNode.next = l2;
                l2 = l2.next;
            }
            listNode = listNode.next;
        }

        while (l1 != null) {
            listNode.next = l1;
            l1 = l1.next;
            listNode = listNode.next;
        }
        while (l2 != null) {
            listNode.next = l2;
            l2 = l2.next;
            listNode = listNode.next;
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
