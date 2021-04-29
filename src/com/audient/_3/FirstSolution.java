package com.audient._3;

import java.util.HashMap;

public class FirstSolution {

	public static void main(String[] args) {
		int result = lengthOfLongestSubstring("abbba");
		System.out.println(result);
	}
	
	/**
	 * 使用滑动窗口来处理
	 * 
	 */
	
	static int lengthOfLongestSubstring(String s) {
		
		int start = 0;	// 窗口起点
		int end = 0;	// 窗口终点
		int maxLength = 0;	// 窗口的最大值
		
		// 将字符串转为数组
		char[] arr = s.toCharArray();
		
		// 定义一个map，key是字符，value是其最后出现的索引位置
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		
		// 遍历数组，当窗口终点到达数组的末尾的时候结束
		while(end != arr.length){
			if(map.containsKey(arr[end])){	// 如果map里面已经有当前的字符
				if(start < map.get(arr[end]) + 1){	// 修改起点，但是需要确定修改之后的起点不能小于当前起点
					start = map.get(arr[end]) + 1;	// 将起点修改为当前字符最后出现的索引位置+1
				}
				
				//System.out.println("已有" + arr[end] + "获取key的值为：" + map.get(arr[end]) + ",将start修改为" + start);
			}
			map.put(arr[end], end);	// 在map中更新当前字符的索引位置
			//System.out.println("map.put(" + arr[end] + "," + end + ")");
			//System.out.println(start + " - " + end);

			maxLength = Math.max(end - start + 1, maxLength);	// 计算出最大的窗口长度

			end++;	// 将窗口终点后移
		}
		return maxLength;
    }
	
}
