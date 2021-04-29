package com.audient._135;

public class FirstSolution {
	
	public static void main(String[] args) {
		int[] ratings = {1,3,2,2,1};
		int result = candy(ratings);
		System.out.println(result);
	}
	
	
	static int candy(int[] ratings) {

		int count = 0;	//糖果总数
		int right = 0;	//记录从右到左遍历的当前糖果数目
		
		if(ratings.length <= 1){	//没有孩子或者只有一个孩子，糖果总数为孩子的总数
			count = ratings.length;
			return count;
		}
		
		int[] candyNum = new int[ratings.length];
		
		// 从左到右遍历
		for(int i = 0; i < ratings.length; i++){
			
			if(i > 0 && ratings[i - 1] < ratings[i]){	// 当前孩子不是第一个孩子且当前孩子的评分大于上一个孩子的评分
				candyNum[i] = candyNum[i - 1] + 1;	// 当前孩子的糖果数等于上一个孩子的糖果数+1
			}else{	// 当前孩子是第一个孩子或者当前孩子的评分小于等于上一个孩子的评分
				candyNum[i] = 1;	// 当前孩子的糖果书为1
			}
		}
		
		// 从右到左遍历
		for(int i = ratings.length - 1; i >= 0; i--){
			if(i < ratings.length - 1 && ratings[i] > ratings[i + 1]){	// 当前孩子不是最后一个孩子且当前孩子的评分高于下一个孩子的评分
				right++;	// 当前孩子的糖果书等于下一个孩子的糖果数+1
			}else{	// 当前孩子是最后一个孩子或者当前孩子的评分小于等于下一个孩子的评分
				right = 1;	// 当前孩子的糖果数为1
			}
			
			count += Math.max(right, candyNum[i]);	// 取较大值
		}

		return count;
    }

}
