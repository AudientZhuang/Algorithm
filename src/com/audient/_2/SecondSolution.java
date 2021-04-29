package com.audient._2;

public class SecondSolution {
	public static void main(String[] args) {
		
		
		ListNode listNode1 = new ListNode(9);
		listNode1.next = null;
		//listNode1.next = new ListNode(4);
		//listNode1.next.next = new ListNode(9);
		
		ListNode listNode2 = new ListNode(1);
		listNode2.next = new ListNode(9);
		listNode2.next.next = new ListNode(9);
		listNode2.next.next.next = new ListNode(9);
		listNode2.next.next.next.next = new ListNode(9);
		listNode2.next.next.next.next.next = new ListNode(9);
		listNode2.next.next.next.next.next.next = new ListNode(9);
		listNode2.next.next.next.next.next.next.next = new ListNode(9);
		listNode2.next.next.next.next.next.next.next.next = new ListNode(9);
		listNode2.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		addTwoNumbers(listNode1, listNode2);
		
	}
	
	static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean flag = false;
		ListNode listNode = new ListNode();
		ListNode head = listNode;
		
		if(l1 != null && l2 != null){
			int result = l1.val + l2.val;
			if(result >= 10){
				flag = true;
				result -= 10;
			}
			listNode.val = result;
			listNode.next = null;
			l1 = l1.next;
			l2 = l2.next;
		}
		
		while(l1 != null && l2 != null){
			int result = l1.val + l2.val;
			if(flag){
				result++;
				flag = false;
			}
			if(result >= 10){
				flag = true;
				result -= 10;
			}
			listNode.next = new ListNode(result);
			listNode = listNode.next;
			listNode.next = null;
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null){
			int result = l1.val;
			if(flag){
				result++;
				flag = false;
			}
			if(result >= 10){
				flag = true;
				result -= 10;
			}
			listNode.next = new ListNode(result);
			listNode = listNode.next;
			listNode.next = null;
			l1 = l1.next;
		}
		
		while(l2 != null){
			int result = l2.val;
			if(flag){
				result++;
				flag = false;
			}
			if(result >= 10){
				flag = true;
				result -= 10;
			}
			listNode.next = new ListNode(result);
			listNode = listNode.next;
			listNode.next = null;
			l2 = l2.next;
		}
		if(flag){
			listNode.next = new ListNode(1);
			listNode = listNode.next;
			listNode.next = null;
		}
		
		/*while(head != null){
			System.out.println(head.val);
			head = head.next;
		}*/
		
		return head;
	}

}
