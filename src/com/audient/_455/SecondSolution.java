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
	 * ����+̰��
	 */
	static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);	// �Ժ��ӵ�θ������g��������
		Arrays.sort(s);	// �Ա��ɵĳߴ�����s��������
		
		int count = 0;	// �ܹ�����ĺ�����
		
		// �Ժ��ӵ�θ��������б���
		for(int i = 0, j = 0; i < g.length && j < s.length; i++,j++){
			// �ҵ��ܹ����㵱ǰ����θ�ڵı��ɳߴ磬Ҳ����s�����е�һ���ܹ����������ģ�Ҳ�Ǳ����ܹ���С���㺢�ӵ�
			while(j < s.length && g[i] > s[j]){
				j++;
			}
			if(j < s.length){
				count++;
			}
		}
		// �����ܹ�����ĺ�����	
		return count;
	}
	
}
