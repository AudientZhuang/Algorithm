package com.audient._1046;

import java.util.Arrays;

public class FirstSolution {
	public static void main(String[] args) {
		int[] stones = {10,4,2,10};
		int result = lastStoneWeight(stones);
		System.out.println(result);
	}
	
	static int lastStoneWeight(int[] stones) {
        if(stones.length == 1){	// ���ֻ��һ��ʯͷ��ֱ�ӷ������ʯͷ������
        	return stones[0];
        }
        
        int start = 0;
        int end = stones.length - 1;	// �����±�
        
		while(end - start > 0){	// ��ʣ�����Ż�����������ʯͷʱ
			Arrays.sort(stones);
			
			/*for(int i = 0; i < stones.length; i++){
				System.out.print(stones[i] + " ");
			}
			System.out.println();*/
			
			if(stones[end - 1] == stones[end]){	// �������ʯͷ�������
				if(end - start == 1){	// ��������ʯͷ�ǽ��������ʯͷ
					return 0;
				}else{	// ���������ʯͷ���ǽ��������ʯͷ
					stones[end - 1] = 0;
					stones[end] = 0;
					start += 2;
				}
			}else{	// �������ʯͷ���������
				int temp = stones[end - 1];
				stones[end - 1] = stones[end] - temp;
				stones[end] = temp - stones[end];
				start += 1;
			}
		}
		
		Arrays.sort(stones);
		return stones[end];
    }
}
