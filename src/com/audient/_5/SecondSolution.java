package com.audient._5;

public class SecondSolution {
	
	public static void main(String[] args) {
		String result = longestPalindrome("abcda");
		System.out.println(result);
	}
	/**
	 * ��̬�滮
	 */
	static String longestPalindrome(String s) {
		
		int len = s.length();	// �ַ�������
		
		// �ַ�������С��2�����ַ������������Ӵ��������ַ���s
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
		
		int maxLength = 0;	// �������Ӵ��ĳ���
		int begin = 0;		//��ʼλ��
		
		// dp[i][j]������ʾs[i][j]�ǲ��ǻ����Ӵ�
		boolean[][] dp = new boolean[len][len];
		
		// ���ַ���ת��Ϊ������ʽ
		char[] arr = s.toCharArray();
		
		// �����ַ������ǻ����Ӵ�
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
