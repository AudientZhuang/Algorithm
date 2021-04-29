package com.audient._6;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		String result = convert("AB",2);
		System.out.println(result);
		
	}
	
	static String convert(String s, int numRows) {
		if(numRows == 1){
			return s;
		}
		
		
		int len = s.length();
		
		char[] arr = s.toCharArray();
		
		char[][] num =  new char[numRows][len];
		
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < len; j++){
				num[i][j] = '-';
			}
		}
		
		int row = 0;	// ����
		int cols = 0;	// ����
		
		//String newStr = "";
		StringBuilder sb = new StringBuilder();
		
		// ��arr�����ÿ���ַ���Ӧ��������
		for(int i = 0; i < len; i++){
			/*
			 * a a a a
			 * aaaaaaa
			 * a a a a
			 * 
			 * 
			 * a  a  a  a
			 * a aa aa a
			 * aa aa aa
			 * a  a  a
			 */
			
			num[row][cols] = arr[i];
			
			if(cols == 0 || ((cols % (numRows - 1)) == 0)){
				if(row == (numRows - 1)){
					cols++;
					row--;
					continue;
				}
				row++;
			}else{
				if(row == 0){
					row++;
					continue;
				}
				row--;
				cols++;
			}	
		}

		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < len; j++){
				if(num[i][j] != '-'){
					sb.append(num[i][j]);
				}
				//System.out.print(num[i][j]);
			}
			//System.out.println();
		}

		return sb.toString();
    }

}
