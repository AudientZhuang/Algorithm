package com.audient._135;

public class FirstSolution {
	
	public static void main(String[] args) {
		int[] ratings = {1,3,2,2,1};
		int result = candy(ratings);
		System.out.println(result);
	}
	
	
	static int candy(int[] ratings) {

		int count = 0;	//�ǹ�����
		int right = 0;	//��¼���ҵ�������ĵ�ǰ�ǹ���Ŀ
		
		if(ratings.length <= 1){	//û�к��ӻ���ֻ��һ�����ӣ��ǹ�����Ϊ���ӵ�����
			count = ratings.length;
			return count;
		}
		
		int[] candyNum = new int[ratings.length];
		
		// �����ұ���
		for(int i = 0; i < ratings.length; i++){
			
			if(i > 0 && ratings[i - 1] < ratings[i]){	// ��ǰ���Ӳ��ǵ�һ�������ҵ�ǰ���ӵ����ִ�����һ�����ӵ�����
				candyNum[i] = candyNum[i - 1] + 1;	// ��ǰ���ӵ��ǹ���������һ�����ӵ��ǹ���+1
			}else{	// ��ǰ�����ǵ�һ�����ӻ��ߵ�ǰ���ӵ�����С�ڵ�����һ�����ӵ�����
				candyNum[i] = 1;	// ��ǰ���ӵ��ǹ���Ϊ1
			}
		}
		
		// ���ҵ������
		for(int i = ratings.length - 1; i >= 0; i--){
			if(i < ratings.length - 1 && ratings[i] > ratings[i + 1]){	// ��ǰ���Ӳ������һ�������ҵ�ǰ���ӵ����ָ�����һ�����ӵ�����
				right++;	// ��ǰ���ӵ��ǹ��������һ�����ӵ��ǹ���+1
			}else{	// ��ǰ���������һ�����ӻ��ߵ�ǰ���ӵ�����С�ڵ�����һ�����ӵ�����
				right = 1;	// ��ǰ���ӵ��ǹ���Ϊ1
			}
			
			count += Math.max(right, candyNum[i]);	// ȡ�ϴ�ֵ
		}

		return count;
    }

}
