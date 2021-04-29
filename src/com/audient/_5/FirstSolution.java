package com.audient._5;

public class FirstSolution {

	public static void main(String[] args) {
		String result = longestPalindrome("ukxidnpsdfwieixhjnannbmtppviyppjgbsludrzdleeiydzawnfmiiztsjqqqnthwinsqnrhfjxtklvbozkaeetmblqbxbugxycrlzizthtuwxlmgfjokhqjyukrftvfwikxlptydybmmzdhworzlaeztwsjyqnshggxdsjrzazphugckgykzhqkdrleaueuajjdpgagwtueoyybzanrvrgevolwssvqimgzpkxehnunycmlnetfaflhusauopyizbcpntywntadciopanyjoamoyexaxulzrktneytynmheigspgyhkelxgwplizyszcwdixzgxzgxiawstbnpjezxinyowmqsysazgwxpthloegxvezsxcvorzquzdtfcvckjpewowazuaynfpxsxrihsfswrmuvluwbdazmcealapulnahgdxxycizeqelesvshkgpavihywwlhdfopmmbwegibxhluantulnccqieyrbjjqtlgkpfezpxmlwpyohdyftzgbeoioquxpnrwrgzlhtlgyfwxtqcgkzcuuwagmlvgiwrhnredtulxudrmepbunyamssrfwyvgabbcfzzjayccvvwxzbfgeglqmuogqmhkjebehtwnmxotjwjszvrvpfpafwomlyqsgnysydfdlbbltlwugtapwgfnsiqxcnmdlrxoodkhaaaiioqglgeyuxqefdxbqbgbltrxcnihfwnzevvtkkvtejtecqyhqwjnnwfrzptzhdnmvsjnnsnixovnotugpzuymkjplctzqbfkdbeinvtgdpcbvzrmxdqthgorpaimpsaenmnyuyoqjqqrtcwiejutafyqmfauufwripmpcoknzyphratopyuadgsfrsrqkfwkdlvuzyepsiolpxkbijqw");
		System.out.println(result);
	}
	
	/**
	 * 暴力解法
	 */
	
	static String longestPalindrome(String s) {

		/*if(s.length() == 1){
			return s;
		}*/
		
		char[] arr = s.toCharArray();
		
		boolean isPalindrome = true;
		
		String result = "";
		
		for(int i = 0; i < arr.length; i++){
			
			
			for(int j = arr.length - 1; j >= i; j--){
				if(result.length() > (j - i + 1)){
					break;
				}
				
				isPalindrome = true;
				for(int m = 0; m < (j - i + 1) / 2; m++){
					if(arr[i + m] != arr[j - m]){
						isPalindrome = false;
					}
				}
				
				if(isPalindrome){
					//System.out.println("i:" + i + ", j:" + j);
					String temp = s.substring(i, j + 1);
					if(result.length() < temp.length()){
						result = temp;
					}
					//System.out.println("满足的字符串：" + temp);
					break;
				}
			}

		}
		
		return result;
    }
	
}
