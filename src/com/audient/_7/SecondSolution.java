package com.audient._7;

public class SecondSolution {
	public static void main(String[] args) {
		
		int result = reverse(-10);
		System.out.println(result);
	}
	/**
	 * ��ȽϷ���һ��������û�п��ٶ��������ռ䣬����ֱ����ԭ�����Ͻ��в���
	 */
	
	static int reverse(int x) {
		int newNum = 0;	// �洢��ת֮�������	
		try{
			// ������xתΪ�ַ���
			String str = x + "";
			
			// ���ַ���תΪ������ʽ
			char[] arr = str.toCharArray();
			int len = arr.length;
			char wrap = '0';
			if(x < 0){	// x�Ǹ���������λ�ò�������1��ʼ��ת
				for(int i = 1; i <= len / 2; i++){
					wrap = arr[i];
					arr[i] = arr[len - i];
					arr[len - i] = wrap;
					//System.out.println("��ʼ����" + arr[i] + " " + arr[len - i]);
				}
			}else{	// x����������0��ʼ��ת
				for(int i = 0; i < len / 2; i++){
					wrap = arr[i];
					arr[i] = arr[len - 1 - i];
					arr[len - 1 - i] = wrap;
					
				}
			}
		
			/*for(int i = 0; i < arr.length; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();*/
			
			newNum = Integer.valueOf(String.valueOf(arr));

			return newNum;
		}catch(Exception e){
			return newNum;
		}
		
		
    }
}
