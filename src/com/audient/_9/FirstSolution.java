package com.audient._9;

public class FirstSolution {

	public static void main(String[] args) {
		boolean result = isPalindrome(1);
		System.out.println(result);
	}
	
	static boolean isPalindrome(int x) {

		String str = x + "";		
		char[] arr = str.toCharArray();
		boolean flag = true;
		for(int i = 0; i< arr.length / 2; i++){
			if(arr[i] != arr[arr.length - 1 - i]){
				flag = false;
				break;
			}
		}
		
		
		return flag;
    }
}
