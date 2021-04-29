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
		// ����һ��LinkedHashMap��keyΪ�ַ���valueΪ���ֵĴ���
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		// ���ַ���תΪ����
		char[] array = s.toCharArray();
		// �������飬������浽map��
		for(int i = 0; i < array.length; i++){
			if(map.containsKey(array[i])){	// �����ǰ�ַ����ǵ�һ�γ���
				// keyΪ��ǰ�ַ���valueΪvalue+1
				map.put(array[i], map.get(array[i]) + 1);
			}else{	// �����ǰ�ַ��ǵ�һ�γ���
				// keyΪ��ǰ�ַ���valueΪ1
				map.put(array[i], 1);
			}
		}
		// ȡ��map��key�ļ���
		Set<Character> keySet = map.keySet();
		// ��������
		for (Character key : keySet) {
			int value = map.get(key);
			if(value == 1){	// ���ڳ��ִ���Ϊ1���ַ�
				// ���ص�ǰ�ַ�������
				return s.indexOf(key);
			}	
		}
		// û�г��ִ���Ϊ1���ַ�������-1
		return -1;
    }

}
