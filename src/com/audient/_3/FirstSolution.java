package com.audient._3;

import java.util.HashMap;

public class FirstSolution {

	public static void main(String[] args) {
		int result = lengthOfLongestSubstring("abbba");
		System.out.println(result);
	}
	
	/**
	 * ʹ�û�������������
	 * 
	 */
	
	static int lengthOfLongestSubstring(String s) {
		
		int start = 0;	// �������
		int end = 0;	// �����յ�
		int maxLength = 0;	// ���ڵ����ֵ
		
		// ���ַ���תΪ����
		char[] arr = s.toCharArray();
		
		// ����һ��map��key���ַ���value���������ֵ�����λ��
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		
		// �������飬�������յ㵽�������ĩβ��ʱ�����
		while(end != arr.length){
			if(map.containsKey(arr[end])){	// ���map�����Ѿ��е�ǰ���ַ�
				if(start < map.get(arr[end]) + 1){	// �޸���㣬������Ҫȷ���޸�֮�����㲻��С�ڵ�ǰ���
					start = map.get(arr[end]) + 1;	// ������޸�Ϊ��ǰ�ַ������ֵ�����λ��+1
				}
				
				//System.out.println("����" + arr[end] + "��ȡkey��ֵΪ��" + map.get(arr[end]) + ",��start�޸�Ϊ" + start);
			}
			map.put(arr[end], end);	// ��map�и��µ�ǰ�ַ�������λ��
			//System.out.println("map.put(" + arr[end] + "," + end + ")");
			//System.out.println(start + " - " + end);

			maxLength = Math.max(end - start + 1, maxLength);	// ��������Ĵ��ڳ���

			end++;	// �������յ����
		}
		return maxLength;
    }
	
}
