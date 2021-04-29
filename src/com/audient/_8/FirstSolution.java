package com.audient._8;

import java.math.BigInteger;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		int result = myAtoi(" ");
		System.out.println(result);
	}

	static int myAtoi(String s) {

		if(s.length() == 0){
			return 0;
		}
		
		int result = 0;
		
		// 将字符串转为数组形式
		char[] arr = s.toCharArray();
		
		int start = -1;	// 数字开始的下标
		int end = -1;	// 数字结束的下标
		
		//boolean flag = true;	// 用来标记第一个非空字符，如果第一个不是正负号或者数字，变为false
		
		// 遍历数组
		for(int i = 0; i < arr.length; i++){
			//System.out.println(i + ":" +arr[i]);
			
			if(start == - 1){	// 当前还没有找到符合条件的字符
				if((arr[i] >= '0' && arr[i] <= '9') || arr[i] == '-' || arr[i] == '+'){	// 当前字符是满足数字条件的第一个字符
					start = i;	// 记录当前下标
					end = i;
					continue;
				}else if(arr[i] == ' '){
					continue;
				}else{
					return result;
				}
				
			}
			
			if(start != -1){	// 找到满足数字条件的字符
				if(end == start){	// 当前只找到一个字符
					if(arr[start] == '-' || arr[start] == '+'){	//这个字符是正号或者负号
						//System.out.println("-----" + arr[i] + "------");
						if(arr[i] >= '0' && arr[i] <= '9'){	// 当前字符是0-9之间的字符
							end = i;
						}else{	// 当前字符不是0-9之间的字符
							
							return result;
						}
					}else{
						if(arr[i] >= '0' && arr[i] <= '9'){	// 当前字符是0-9之间的字符
							end = i;
						}else{	// 当前字符不是0-9之间的字符
							break;	// 结束循环
						}
					}
					
				}else{
					if(arr[i] >= '0' && arr[i] <= '9'){	// 当前字符是0-9之间的字符
						end = i;
					}else{	// 当前字符不是0-9之间的字符
						break;	// 结束循环
					}
				}
			}
			
		}
		//System.out.println("end : " + end + "start : " + start);
		if(end >= start){
			if(start == -1 && end == -1){
				return result;
			}
			
			if(start == end && (arr[start] == '-' || arr[end] == '+')){
				return result;
			}
			
			
			BigInteger num = new BigInteger(s.substring(start, end + 1));
			
			int comp1 = num.compareTo(BigInteger.valueOf(Integer.MAX_VALUE));
			int comp2 = num.compareTo(BigInteger.valueOf(Integer.MIN_VALUE));
			if(comp1 == 1){
				result = Integer.MAX_VALUE;
			}
			if(comp2 == -1){
				result = Integer.MIN_VALUE;
			}
			if(comp1 != 1 && comp2 != -1){
				result = (int)num.longValue();
			}
		}
		
		return result;
    }
	
	
}
