package com.audient._4;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		int[] nums1 = {1};
		int[] nums2 = {2,3,4};
		
		double result = findMedianSortedArrays(nums1,nums2);
		System.out.println(result);
		
	}

	static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		double median = 0;	// 中位数
		
		boolean flag = false;	// 判断这两个数组的中位数是单个数决定还是由两个数共同决定，false表示单个数，true表示两个数
		
		int position = 1;	// 中位数的位置
		int count = 0;		// 计算当前遍历了多少个数
		
		if((nums1.length + nums2.length) % 2 == 0){	// 如果两个数组的长度相加是偶数，则中位数是由两个中间值共同决定
			flag = true;
			position = (nums1.length + nums2.length) / 2;
		}else{	// 如果两个数组长度相加为奇数，取中间的数即可
			position = (nums1.length + nums2.length) / 2 + 1;
		}
		
		
		//System.out.println(flag);
		//System.out.println(position);
		
		//数组1为空数组
		if(nums1.length == 0){
			if(flag){	// 需要两个数求平均值
				median = (nums2[position - 1] * 1.0 + nums2[position] * 1.0) / 2.0;
			}else{	// 需要一个数
				median = nums2[position - 1];
			}
			// 返回中位数
			return median;
		}
		// 数组2为空数组
		if(nums2.length == 0){
			if(flag){	// 需要两个数求平均值
				median = (nums1[position - 1] * 1.0 + nums1[position] * 1.0) / 2.0;
			}else{	// 需要一个数
				median = nums1[position - 1];
			}
			// 返回中位数
			return median;
		}
		
		int index1 = 0;	// 数组1的索引
		int index2 = 0;	// 数组2的索引
		
		int num1 = -1;	// 求中位数的第一个值
		int num2 = -1;	// 求中位数的第二个值
		
		// 当遍历的值的个数超过中位数的位置/数组1已经没有值/数组2已经没有值 时跳出循环
		while(count < position && index1 < nums1.length && index2 < nums2.length){
			// 遍历的值的个数+1
			count++;
			
			if(nums1[index1] <= nums2[index2]){	// 数组1的值小于等于数组2的值
			
				if(count == position){	// 当前的数是中位数
					if(flag){	// 需要两个数
						// 第一个数是数组1的值
						num1 = nums1[index1];
						
						// 第二个数
						if(index1 < nums1.length - 1){	// 如果数组1当前的值不是数组1的最后一个数
							if(nums1[index1 + 1] <= nums2[index2]){	// 数组1的值小于等于数组2的值，取数组1的值作为第二个数
								num2 = nums1[index1 + 1];
							}else{	// 数组1的值大于数组2的值，取数组2的值作为第二个数
								num2 = nums2[index2];
							}
						}else{	// 数组1当前的值是数组1的最后一个数，取数组2的值作为第二个数
							num2 = nums2[index2];
						}
						
					}else{	// 需要一个数，也就是数组1的值
						num1 = nums1[index1];
					}
				}
				index1++;	// 索引后移
			}else{	// 数组1的值大于数组2的值
				
				if(count == position){	// 当前的数是中位数
					if(flag){	// 需要两个数
						// 第一个数是数组2的值
						num2 = nums2[index2];
						
						// 第二个数
						if(index2 < nums2.length - 1){	// 如果数组2当前的值不是数组2的最后一个数
							if(nums2[index2 + 1] <= nums1[index1]){	// 数组2的值小于等于数组1的值，取数组2的值作为第二个数
								num1 = nums2[index2 + 1];
							}else{	// 数组2的值大于数组1的值，取数组1的值作为第二个数
								num1 = nums1[index1];
							}
						}else{	// 数组2当前的值是数组2的最后一个数，取数组1的值作为第二个数
							num1 = nums1[index1];
						}
					}else{ // 需要一个数，也就是数组2的值
						num2 = nums2[index2];
					}
				}
				index2++;	// 索引后移
			}
		}
		//System.out.println(count);
		//System.out.println(index2);
		
		// 如果还没有遍历到中位数的位置（当数组1遍历完或者数组2遍历完可能会出现这种情况）
		if(count < position){
			if(index1 == nums1.length){	// 数组1遍历结束了，中位数在数组2当中
				if(flag){	// 需要两个数
					index2 += position - count - 1;
					num1 = nums2[index2 + 1];
					num2 = nums2[index2];
					
				}else{	// 需要一个数
					index2 += position - count - 1;
					num2 = nums2[index2];
				}	
			}else{	// 数组2遍历结束了，中位数在数组1当中
				if(flag){	// 需要两个数
					index1 += position - count - 1;
					num1 = nums1[index1];
					num2 = nums1[index1 + 1];
				}else{	// 需要一个数
					index1 += position - count - 1;
					num1 = nums1[index1];
				}	
			}	
		}
		
		
		//System.out.println(num1 + " " + num2);
		if(flag){	// 需要两个数
			median = (num1 * 1.0 + num2 * 1.0) / 2;
		}else{	// 需要一个数
			if(num1 != -1){	//num1是这个数
				median = num1 * 1.0;
			}else{	//num2是这个数
				median = num2 * 1.0;
			}
		}
		return median;
    }
	
}
