package com.audient._7;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		int result = reverse(0);
		System.out.println(result);
	}
	
	static int reverse(int x) {
		int newNum = 0;	// �洢��ת֮�������	
		try{
			// ������xתΪ�ַ���
			String str = x + "";
			
			// ���ַ���תΪ������ʽ
			char[] arr = str.toCharArray();
			int len = arr.length;
			
			char[] newStr = new char[len];	// �����洢��ת֮�������
			
			if(x < 0){	// x�Ǹ���������λ�ò�������1��ʼ��ת
				newStr[0] = '-';
				for(int i = len - 1; i > 0; i--){
					newStr[len - i] = arr[i];
				}
			}else{	// x����������0��ʼ��ת
				for(int i = len - 1; i >= 0; i--){
					newStr[len - 1 - i] = arr[i];
				}
			}
		
			/*for(int i = 0; i < newStr.length; i++){
				System.out.print(newStr[i] + " ");
			}
			System.out.println();*/
			
			newNum = Integer.valueOf(String.valueOf(newStr));

			return newNum;
		}catch(Exception e){
			return newNum;
		}
		
		
    }

}
