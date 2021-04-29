package com.audient._455;

import java.util.Arrays;

public class SecondSolution {
	
	public static void main(String[] args) {
		int[] g = {1,2,3};
		int[] s = {1,1};
		
		int result = findContentChildren(g,s);
		System.out.println(result);
	}

	/**
	 * 排序+贪心
	 */
	static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);	// 对孩子的胃口数组g进行排序
		Arrays.sort(s);	// 对饼干的尺寸数组s进行排序
		
		int count = 0;	// 能够满足的孩子数
		
		// 对孩子的胃口数组进行遍历
		for(int i = 0, j = 0; i < g.length && j < s.length; i++,j++){
			// 找到能够满足当前孩子胃口的饼干尺寸，也就是s数组中第一个能够满足条件的，也是饼干能够最小满足孩子的
			while(j < s.length && g[i] > s[j]){
				j++;
			}
			if(j < s.length){
				count++;
			}
		}
		// 返回能够满足的孩子数	
		return count;
	}
	
}
