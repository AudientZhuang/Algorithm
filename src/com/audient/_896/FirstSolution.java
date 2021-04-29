package com.audient._896;


public class FirstSolution {
	public static void main(String[] args) {

		int[] A = {5,4,2};
		automantoic(A);
		
	}
	
	
	static boolean automantoic(int[] A){
		int i;
		int n = 0;
		for(i = 0; i < A.length - 1; i++){
			if(A[i] == A[i + 1]){
				continue;
			}else{
				if(A[i] < A[i + 1] && n == -1){
					return false;
				}else if(A[i] > A[i + 1] && n == 1){
					return false;
				}else{
				}
				n = A[i] < A[i + 1] ? 1 : -1;
			}
		}
		if(i >= A.length - 1){
			return true;
		}
		return false;
	}
	

}
