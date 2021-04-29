package com.audient._5;

public class ThirdSolution {
	
	public static void main(String[] args) {
		String result = longestPalindrome("abccba");
		System.out.println(result);
	}
	
	
	/**
	 * 中心扩展算法
	 */
	static String longestPalindrome(String s) {
		
		char[] arr = s.toCharArray();
		
		
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < arr.length; i++){
			int len = 0;
			int len1 = expand(arr, i, i);
			int len2 = expand(arr, i, i + 1);
			len = Math.max(len1, len2);
			if(len > end - start){
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}		
		}
		return s.substring(start, end + 1);
	}
	
	
	static int expand(char[] s, int left, int right){
		while(left >= 0 && right < s.length && s[left] == s[right]){
			left--;
			right++;
		}
		return right - left - 1;
	}

}
