package com.audient._188;

import java.util.Arrays;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		int[] prices = {1,2,5,3};
		int result = maxProfit(1, prices);
		//System.out.println(result);
	}
	
	static int maxProfit(int k, int[] prices) {
		// ����һ�ݼ۸�����
		int[] sortArr = Arrays.copyOf(prices, prices.length);
		// �Ը��Ƶ������������
		Arrays.sort(sortArr);
		
		// ��ӡ
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
