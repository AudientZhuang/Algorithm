package com.audient._2;

import java.math.BigInteger;

public class FirstSolution {

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
		int len1 = 0, len2 = 0;	// 记录链表的长度
		// 定义两个数组，来存储数字
		int[] arr1 = new int[100];	// 对应l1
		int[] arr2 = new int[100];	// 对应l2
		
		char[] ch1 = new char[100];
		char[] ch2 = new char[100];
		
		//long num1 = 0, num2 = 0;	// 两个链表对应的真实数字
		
		
		//long sum = 0; // 两数之和
		
		
		// 将两个链表分别存储到数组中，并计算长度，也就是数字的位数
		while(l1 != null){
			arr1[len1] = l1.val;
			l1 = l1.next;
			len1++;
		}
		while(l2 != null){
			arr2[len2] = l2.val;
			l2 = l2.next;
			len2++;
		}
		
		int index1 = 0;
		int index2 = 0;
		
		// 将数字数组转为字符数组
		for(int i = arr1.length - 1; i >= 0; i--){
			//System.out.println(arr1[i]);
			ch1[index1++] = Character.forDigit(arr1[i], 10);
		}
		for(int i = arr2.length - 1; i >= 0; i--){
			ch2[index2++] = Character.forDigit(arr2[i], 10);
		}
		
		String str1 = String.valueOf(ch1, 100 - len1, len1);
		String str2 = String.valueOf(ch2, 100 - len2, len2);
		
		//System.out.println(str1);
		//System.out.println(str2);
		
		BigInteger num1 = new BigInteger(str1);
		BigInteger num2 = new BigInteger(str2);
		BigInteger sum = num1.add(num2);
		
		//System.out.println(sum.toString());
		
		
		
		/*// 将两个数组转化为一个真实的数字
		for(int i = 0; i < len1; i++){
			//len1--;
			//num1 += arr1[i] * Math.pow(10, (len1));
			num1 += arr1[i] * Math.pow(10, i);
		}
		for(int i = 0; i < len2; i++){
			//len2--;
			//num2 += arr2[i] * Math.pow(10, (len2));
			num2 += arr2[i] * Math.pow(10, i);
		}
		sum = num1 + num2;	
		System.out.println(num1 + " " + num2);
		*/
		// 将数字转为字符串
		String str = sum + "";
		//System.out.println(str);
		// 将字符串转为数组
		char[] number = str.toCharArray();
		// 定义一个链表
		ListNode listNode = new ListNode();
		// 记录头节点
		ListNode head = listNode;
		
		// 将计算结果的数组从尾到头插入链表中
		for(int i = number.length - 1; i >= 0; i--){
			if(i == number.length - 1){
				listNode.val = number[i] - 48;
				continue;
			}
			listNode.next = new ListNode(number[i] - 48);
			listNode = listNode.next;
		}
				
		/*while(head != null){
			System.out.println(head.val);
			head = head.next;
		}*/
		return head;
        
    }
	
	
	
	
	
}
