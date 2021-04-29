package com.audient._23;

public class FirstSolution {

    public static void main(String[] args) {

    }



    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = new ListNode(); // 头结点
        int len = lists.length;
        if (len == 0) { // 链表数组为空
            return head;
        } else if (len == 1) {  // 链表数组中只有一个链表
            head = lists[0];
            return head;
        } else {

        }

        int min = lists[0].val;
        int count = 1;  // 用来记录当前还有多少个不为空的链表
        int index = 0;  // 用来记录最后一个不为空的链表的位置
        for (int i = 1; i < len; i++) {
            if (lists[i] != null) {
                count++;
                min = min < lists[i].val ? min : lists[i].val;
            }
        }






        return null;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
