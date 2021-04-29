package com.audient._455;

public class FirstSolution {
	
	public static void main(String[] args) {
		int[] g = {1,2};
		int[] s = {1,2,3};
		
		int result = findContentChildren(g,s);
		System.out.println(result);
	}
	
	static int findContentChildren(int[] g, int[] s) {

		int count = 0;	// 能够满足的孩子数
		
		/**
		 * 遍历饼干的尺寸数组s，每一个饼干都进行遍历胃口数组g，找到最接近尺寸的胃口将胃口变为-1
		 */
		// 遍历饼干的尺寸数组s
		for(int i = 0; i < s.length; i++){
			
			int pre = 0;
			int index = -1;
			// 遍历孩子的胃口数组g
			for(int j = 0; j < g.length; j++){

				if(g[j] != -1){	// 如果当前孩子未分配到饼干
					if(s[i] >= g[j]){	// 当前饼干可以满足当前孩子
						if(g[j] > pre){	// 当前孩子的胃口比预分配的孩子的胃口大
							pre = g[j];	// 将预分配的孩子更改为当前孩子
							index = j;	// 记录当前孩子的索引
						}
					}
				}
			}
			// 如果当前饼干可以满足某个孩子的胃口
			if(pre != 0){
				count++;	// 能够满足的孩子数+1
				g[index] = -1;	// 将孩子的胃口修改为-1，表示当前孩子已经满足
			}
		}
		// 返回能够满足的孩子数
		return count;
    }

}
