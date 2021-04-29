package com.audient._6;

import java.util.ArrayList;

public class SecondSolution {
	
	public static void main(String[] args) {
		
	}

	
	static String convert(String s, int numRows) {
		
		if(numRows == 1){
			return s;
		}
		
		ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
		for(int i = 0; i < numRows; i++){
			list.add(new StringBuilder());
		}
		
		char[] arr = s.toCharArray();
		
		for(int i = 0; i < arr.length; i++){
			
		}
		
		
		return "";
	}
}
