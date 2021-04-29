package com.audient._7;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		int result = reverse(0);
		System.out.println(result);
	}
	
	static int reverse(int x) {
		int newNum = 0;	// 存储反转之后的数字	
		try{
			// 将数字x转为字符串
			String str = x + "";
			
			// 将字符串转为数组形式
			char[] arr = str.toCharArray();
			int len = arr.length;
			
			char[] newStr = new char[len];	// 用来存储反转之后的数组
			
			if(x < 0){	// x是负数，负号位置不动，从1开始反转
				newStr[0] = '-';
				for(int i = len - 1; i > 0; i--){
					newStr[len - i] = arr[i];
				}
			}else{	// x是正数，从0开始反转
				for(int i = len - 1; i >= 0; i--){
					newStr[len - 1 - i] = arr[i];
				}
			}
		
			/*for(int i = 0; i < newStr.length; i++){
				System.out.print(newStr[i] + " ");
			}
			System.out.println();*/
			
			newNum = Integer.valueOf(String.valueOf(newStr));

			return newNum;
		}catch(Exception e){
			return newNum;
		}
		
		
    }

}
