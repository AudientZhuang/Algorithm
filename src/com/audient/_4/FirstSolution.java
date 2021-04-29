package com.audient._4;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		int[] nums1 = {1};
		int[] nums2 = {2,3,4};
		
		double result = findMedianSortedArrays(nums1,nums2);
		System.out.println(result);
		
	}

	static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		double median = 0;	// ��λ��
		
		boolean flag = false;	// �ж��������������λ���ǵ�����������������������ͬ������false��ʾ��������true��ʾ������
		
		int position = 1;	// ��λ����λ��
		int count = 0;		// ���㵱ǰ�����˶��ٸ���
		
		if((nums1.length + nums2.length) % 2 == 0){	// �����������ĳ��������ż��������λ�����������м�ֵ��ͬ����
			flag = true;
			position = (nums1.length + nums2.length) / 2;
		}else{	// ����������鳤�����Ϊ������ȡ�м��������
			position = (nums1.length + nums2.length) / 2 + 1;
		}
		
		
		//System.out.println(flag);
		//System.out.println(position);
		
		//����1Ϊ������
		if(nums1.length == 0){
			if(flag){	// ��Ҫ��������ƽ��ֵ
				median = (nums2[position - 1] * 1.0 + nums2[position] * 1.0) / 2.0;
			}else{	// ��Ҫһ����
				median = nums2[position - 1];
			}
			// ������λ��
			return median;
		}
		// ����2Ϊ������
		if(nums2.length == 0){
			if(flag){	// ��Ҫ��������ƽ��ֵ
				median = (nums1[position - 1] * 1.0 + nums1[position] * 1.0) / 2.0;
			}else{	// ��Ҫһ����
				median = nums1[position - 1];
			}
			// ������λ��
			return median;
		}
		
		int index1 = 0;	// ����1������
		int index2 = 0;	// ����2������
		
		int num1 = -1;	// ����λ���ĵ�һ��ֵ
		int num2 = -1;	// ����λ���ĵڶ���ֵ
		
		// ��������ֵ�ĸ���������λ����λ��/����1�Ѿ�û��ֵ/����2�Ѿ�û��ֵ ʱ����ѭ��
		while(count < position && index1 < nums1.length && index2 < nums2.length){
			// ������ֵ�ĸ���+1
			count++;
			
			if(nums1[index1] <= nums2[index2]){	// ����1��ֵС�ڵ�������2��ֵ
			
				if(count == position){	// ��ǰ��������λ��
					if(flag){	// ��Ҫ������
						// ��һ����������1��ֵ
						num1 = nums1[index1];
						
						// �ڶ�����
						if(index1 < nums1.length - 1){	// �������1��ǰ��ֵ��������1�����һ����
							if(nums1[index1 + 1] <= nums2[index2]){	// ����1��ֵС�ڵ�������2��ֵ��ȡ����1��ֵ��Ϊ�ڶ�����
								num2 = nums1[index1 + 1];
							}else{	// ����1��ֵ��������2��ֵ��ȡ����2��ֵ��Ϊ�ڶ�����
								num2 = nums2[index2];
							}
						}else{	// ����1��ǰ��ֵ������1�����һ������ȡ����2��ֵ��Ϊ�ڶ�����
							num2 = nums2[index2];
						}
						
					}else{	// ��Ҫһ������Ҳ��������1��ֵ
						num1 = nums1[index1];
					}
				}
				index1++;	// ��������
			}else{	// ����1��ֵ��������2��ֵ
				
				if(count == position){	// ��ǰ��������λ��
					if(flag){	// ��Ҫ������
						// ��һ����������2��ֵ
						num2 = nums2[index2];
						
						// �ڶ�����
						if(index2 < nums2.length - 1){	// �������2��ǰ��ֵ��������2�����һ����
							if(nums2[index2 + 1] <= nums1[index1]){	// ����2��ֵС�ڵ�������1��ֵ��ȡ����2��ֵ��Ϊ�ڶ�����
								num1 = nums2[index2 + 1];
							}else{	// ����2��ֵ��������1��ֵ��ȡ����1��ֵ��Ϊ�ڶ�����
								num1 = nums1[index1];
							}
						}else{	// ����2��ǰ��ֵ������2�����һ������ȡ����1��ֵ��Ϊ�ڶ�����
							num1 = nums1[index1];
						}
					}else{ // ��Ҫһ������Ҳ��������2��ֵ
						num2 = nums2[index2];
					}
				}
				index2++;	// ��������
			}
		}
		//System.out.println(count);
		//System.out.println(index2);
		
		// �����û�б�������λ����λ�ã�������1�������������2��������ܻ�������������
		if(count < position){
			if(index1 == nums1.length){	// ����1���������ˣ���λ��������2����
				if(flag){	// ��Ҫ������
					index2 += position - count - 1;
					num1 = nums2[index2 + 1];
					num2 = nums2[index2];
					
				}else{	// ��Ҫһ����
					index2 += position - count - 1;
					num2 = nums2[index2];
				}	
			}else{	// ����2���������ˣ���λ��������1����
				if(flag){	// ��Ҫ������
					index1 += position - count - 1;
					num1 = nums1[index1];
					num2 = nums1[index1 + 1];
				}else{	// ��Ҫһ����
					index1 += position - count - 1;
					num1 = nums1[index1];
				}	
			}	
		}
		
		
		//System.out.println(num1 + " " + num2);
		if(flag){	// ��Ҫ������
			median = (num1 * 1.0 + num2 * 1.0) / 2;
		}else{	// ��Ҫһ����
			if(num1 != -1){	//num1�������
				median = num1 * 1.0;
			}else{	//num2�������
				median = num2 * 1.0;
			}
		}
		return median;
    }
	
}
