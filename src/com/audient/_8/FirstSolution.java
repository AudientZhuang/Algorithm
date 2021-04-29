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
		
		// ���ַ���תΪ������ʽ
		char[] arr = s.toCharArray();
		
		int start = -1;	// ���ֿ�ʼ���±�
		int end = -1;	// ���ֽ������±�
		
		//boolean flag = true;	// ������ǵ�һ���ǿ��ַ��������һ�����������Ż������֣���Ϊfalse
		
		// ��������
		for(int i = 0; i < arr.length; i++){
			//System.out.println(i + ":" +arr[i]);
			
			if(start == - 1){	// ��ǰ��û���ҵ������������ַ�
				if((arr[i] >= '0' && arr[i] <= '9') || arr[i] == '-' || arr[i] == '+'){	// ��ǰ�ַ����������������ĵ�һ���ַ�
					start = i;	// ��¼��ǰ�±�
					end = i;
					continue;
				}else if(arr[i] == ' '){
					continue;
				}else{
					return result;
				}
				
			}
			
			if(start != -1){	// �ҵ����������������ַ�
				if(end == start){	// ��ǰֻ�ҵ�һ���ַ�
					if(arr[start] == '-' || arr[start] == '+'){	//����ַ������Ż��߸���
						//System.out.println("-----" + arr[i] + "------");
						if(arr[i] >= '0' && arr[i] <= '9'){	// ��ǰ�ַ���0-9֮����ַ�
							end = i;
						}else{	// ��ǰ�ַ�����0-9֮����ַ�
							
							return result;
						}
					}else{
						if(arr[i] >= '0' && arr[i] <= '9'){	// ��ǰ�ַ���0-9֮����ַ�
							end = i;
						}else{	// ��ǰ�ַ�����0-9֮����ַ�
							break;	// ����ѭ��
						}
					}
					
				}else{
					if(arr[i] >= '0' && arr[i] <= '9'){	// ��ǰ�ַ���0-9֮����ַ�
						end = i;
					}else{	// ��ǰ�ַ�����0-9֮����ַ�
						break;	// ����ѭ��
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
