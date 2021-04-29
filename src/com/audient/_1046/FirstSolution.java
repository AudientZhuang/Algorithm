package com.audient._1046;

import java.util.Arrays;

public class FirstSolution {
	public static void main(String[] args) {
		int[] stones = {10,4,2,10};
		int result = lastStoneWeight(stones);
		System.out.println(result);
	}
	
	static int lastStoneWeight(int[] stones) {
        if(stones.length == 1){	// 如果只有一块石头，直接返回这颗石头的重量
        	return stones[0];
        }
        
        int start = 0;
        int end = stones.length - 1;	// 结束下标
        
		while(end - start > 0){	// 当剩下两颗或者两颗以上石头时
			Arrays.sort(stones);
			
			/*for(int i = 0; i < stones.length; i++){
				System.out.print(stones[i] + " ");
			}
			System.out.println();*/
			
			if(stones[end - 1] == stones[end]){	// 如果两颗石头重量相等
				if(end - start == 1){	// 且这两颗石头是仅存的两颗石头
					return 0;
				}else{	// 如果这两颗石头不是仅存的两颗石头
					stones[end - 1] = 0;
					stones[end] = 0;
					start += 2;
				}
			}else{	// 如果两颗石头重量不相等
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
