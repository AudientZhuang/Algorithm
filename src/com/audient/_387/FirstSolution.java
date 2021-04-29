package com.audient._387;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		int result = firstUniqChar("dddccdbba");
		System.out.println(result);
	}
	
	static int firstUniqChar(String s) {
		// 定义一个LinkedHashMap，key为字符，value为出现的次数
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		// 将字符串转为数组
		char[] array = s.toCharArray();
		// 遍历数组，将数组存到map中
		for(int i = 0; i < array.length; i++){
			if(map.containsKey(array[i])){	// 如果当前字符不是第一次出现
				// key为当前字符，value为value+1
				map.put(array[i], map.get(array[i]) + 1);
			}else{	// 如果当前字符是第一次出现
				// key为当前字符，value为1
				map.put(array[i], 1);
			}
		}
		// 取出map的key的集合
		Set<Character> keySet = map.keySet();
		// 遍历集合
		for (Character key : keySet) {
			int value = map.get(key);
			if(value == 1){	// 存在出现次数为1的字符
				// 返回当前字符的索引
				return s.indexOf(key);
			}	
		}
		// 没有出现次数为1的字符，返回-1
		return -1;
    }

}
