package com.audient._5;

public class SecondSolution {
	
	public static void main(String[] args) {
		String result = longestPalindrome("abcda");
		System.out.println(result);
	}
	/**
	 * 动态规划
	 */
	static String longestPalindrome(String s) {
		
		int len = s.length();	// 字符串长度
		
		// 字符串长度小于2，该字符串是最大回文子串，返回字符串s
		if(len < 2){
			return s;
		}
		
		/*if(len == 2){
			if(s.charAt(0) == s.charAt(1)){
				return s;
			}else{
				return s.charAt(0) + "";
			}
		}*/
		
		int maxLength = 0;	// 最大回文子串的长度
		int begin = 0;		//开始位置
		
		// dp[i][j]用来表示s[i][j]是不是回文子串
		boolean[][] dp = new boolean[len][len];
		
		// 将字符串转换为数组形式
		char[] arr = s.toCharArray();
		
		// 单个字符本身是回文子串
		for(int i = 0; i < len; i++){
			dp[i][i] = true;
		}
		
		for(int i = 0; i < len; i++){
			
			for(int j = 0; j <= i; j++){
				
				if(arr[i] != arr[j]){
					dp[j][i] = false;
				}else{
					if(i - j < 3){
						dp[j][i] = true;
					}else{
						dp[j][i] = dp[j + 1][i - 1];
					}
				}
				
				if(dp[j][i] && i - j + 1 > maxLength){
					maxLength = i - j + 1;
					begin = j;
				}
				
			}
			
		}

		return s.substring(begin, begin + maxLength);
	}
	
}
