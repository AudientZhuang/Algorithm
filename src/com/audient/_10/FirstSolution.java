package com.audient._10;

public class FirstSolution {
	
	public static void main(String[] args) {
		
		/*boolean result = isMatch("aab","c*a*b");
		System.out.println(result);*/
	}
	
	static boolean isMatch(String s, String p) {
        boolean flag = true;	// �����ж��Ƿ�ƥ��
        
        if(s.equals(p)){	// �ַ������ַ�������ȣ�ƥ��ɹ�������������ַ������ַ����ɶ�Ϊ�յ����
        	return flag;
        }
		
        if(p.length() == 0){	// �ַ�����Ϊ�գ�ƥ��ʧ��
        	flag = false;
        	return flag;
        }
        
        char[] sArr = s.toCharArray();	// ���ַ���תΪ������ʽ
        char[] pArr = p.toCharArray();	// ���ַ�����תΪ������ʽ
        
        int index = 0;
        
        // ���ַ�����һƥ��
        for(int i = 0; i < sArr.length; i++){
        	if(pArr[index] == '*'){	// ��ǰ�ַ�Ϊ'*'
        		if(pArr[index - 1] == sArr[i]){	// �����ǰ�ַ����ַ����ɵ���һ���ַ����
        			continue;
        		}
        		if(pArr[index - 1] == '.'){	// �����ǰ�ַ����ַ����ɵ���һ���ַ����
        			continue;
        		}
        		if(index < pArr.length - 1){	// ����ַ����ɺ��滹���ַ�
        			if(pArr[index + 1] == sArr[i]){	// ��ǰ�ַ����ַ����ɺ�һ��ƥ��
        				index += 2;
        				continue;
        			}
        			// ��ǰ�ַ����ַ����ɺ�һ����ƥ��
        			if(pArr[index] == '.'){	// ��ǰ�ַ�Ϊ'.'
                		index += 2;
                		continue;
                	}
        			
        			flag = false;
        			
        		}
        	}
        	
        	if(pArr[index] == '.'){	// ��ǰ�ַ�Ϊ'.'
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
