package com.audient._455;

public class FirstSolution {
	
	public static void main(String[] args) {
		int[] g = {1,2};
		int[] s = {1,2,3};
		
		int result = findContentChildren(g,s);
		System.out.println(result);
	}
	
	static int findContentChildren(int[] g, int[] s) {

		int count = 0;	// �ܹ�����ĺ�����
		
		/**
		 * �������ɵĳߴ�����s��ÿһ�����ɶ����б���θ������g���ҵ���ӽ��ߴ��θ�ڽ�θ�ڱ�Ϊ-1
		 */
		// �������ɵĳߴ�����s
		for(int i = 0; i < s.length; i++){
			
			int pre = 0;
			int index = -1;
			// �������ӵ�θ������g
			for(int j = 0; j < g.length; j++){

				if(g[j] != -1){	// �����ǰ����δ���䵽����
					if(s[i] >= g[j]){	// ��ǰ���ɿ������㵱ǰ����
						if(g[j] > pre){	// ��ǰ���ӵ�θ�ڱ�Ԥ����ĺ��ӵ�θ�ڴ�
							pre = g[j];	// ��Ԥ����ĺ��Ӹ���Ϊ��ǰ����
							index = j;	// ��¼��ǰ���ӵ�����
						}
					}
				}
			}
			// �����ǰ���ɿ�������ĳ�����ӵ�θ��
			if(pre != 0){
				count++;	// �ܹ�����ĺ�����+1
				g[index] = -1;	// �����ӵ�θ���޸�Ϊ-1����ʾ��ǰ�����Ѿ�����
			}
		}
		// �����ܹ�����ĺ�����
		return count;
    }

}
