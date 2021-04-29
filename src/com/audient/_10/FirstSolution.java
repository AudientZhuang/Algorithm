package com.audient._10;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		/*boolean result = isMatch("aab","c*a*b");
		System.out.println(result);*/
	}
	
	static boolean isMatch(String s, String p) {
        boolean flag = true;	// 用来判断是否匹配
        
        if(s.equals(p)){	// 字符串和字符规律相等，匹配成功，这里包含了字符串和字符规律都为空的情况
        	return flag;
        }
		
        if(p.length() == 0){	// 字符规律为空，匹配失败
        	flag = false;
        	return flag;
        }
        
        char[] sArr = s.toCharArray();	// 将字符串转为数组形式
        char[] pArr = p.toCharArray();	// 将字符规律转为数组形式
        
        int index = 0;
        
        // 对字符串逐一匹配
        for(int i = 0; i < sArr.length; i++){
        	if(pArr[index] == '*'){	// 当前字符为'*'
        		if(pArr[index - 1] == sArr[i]){	// 如果当前字符与字符规律的上一个字符相等
        			continue;
        		}
        		if(pArr[index - 1] == '.'){	// 如果当前字符与字符规律的上一个字符相等
        			continue;
        		}
        		if(index < pArr.length - 1){	// 如果字符规律后面还有字符
        			if(pArr[index + 1] == sArr[i]){	// 当前字符与字符规律后一个匹配
        				index += 2;
        				continue;
        			}
        			// 当前字符与字符规律后一个不匹配
        			if(pArr[index] == '.'){	// 当前字符为'.'
                		index += 2;
                		continue;
                	}
        			
        			flag = false;
        			
        		}
        	}
        	
        	if(pArr[index] == '.'){	// 当前字符为'.'
        		index++;
        		continue;
        	}
        	
        	if(sArr[i] == pArr[index]){
        		if(i != sArr.length && index == pArr.length - 1){
        			flag = false;
        			break;
        		}
        		index++;
        	}else{
        		flag = false;
        		break;
        	}
        	
        }
		
		
		return flag;
    }

}
