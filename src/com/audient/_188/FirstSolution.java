package com.audient._188;

import java.util.Arrays;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		int[] prices = {1,2,5,3};
		int result = maxProfit(1, prices);
		//System.out.println(result);
	}
	
	static int maxProfit(int k, int[] prices) {
		// 复制一份价格数组
		int[] sortArr = Arrays.copyOf(prices, prices.length);
		// 对复制的数组进行排序
		Arrays.sort(sortArr);
		
		// 打印
		for(int i = 0; i < prices.length; i++){
			System.out.print(prices[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i < sortArr.length; i++){
			System.out.print(sortArr[i] + " ");
		}

		
		return 0;
    }

}
