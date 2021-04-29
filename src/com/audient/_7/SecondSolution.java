package com.audient._7;

public class SecondSolution {
	public static void main(String[] args) {
		
		int result = reverse(-10);
		System.out.println(result);
	}
	/**
	 * 相比较方法一，方法二没有开辟额外的数组空间，而是直接在原数组上进行操作
	 */
	
	static int reverse(int x) {
		int newNum = 0;	// 存储反转之后的数字	
		try{
			// 将数字x转为字符串
			String str = x + "";
			
			// 将字符串转为数组形式
			char[] arr = str.toCharArray();
			int len = arr.length;
			char wrap = '0';
			if(x < 0){	// x是负数，负号位置不动，从1开始反转
				for(int i = 1; i <= len / 2; i++){
					wrap = arr[i];
					arr[i] = arr[len - i];
					arr[len - i] = wrap;
					//System.out.println("开始交换" + arr[i] + " " + arr[len - i]);
				}
			}else{	// x是正数，从0开始反转
				for(int i = 0; i < len / 2; i++){
					wrap = arr[i];
					arr[i] = arr[len - 1 - i];
					arr[len - 1 - i] = wrap;
					
				}
			}
		
			/*for(int i = 0; i < arr.length; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();*/
			
			newNum = Integer.valueOf(String.valueOf(arr));

			return newNum;
		}catch(Exception e){
			return newNum;
		}
		
		
    }
}
