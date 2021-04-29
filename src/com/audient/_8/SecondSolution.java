package com.audient._8;

import java.util.HashMap;
import java.util.Map;

public class SecondSolution {
	
public static void main(String[] args) {
		
		int result = myAtoi("-91283472332");
		System.out.println(result);
	}

	static int myAtoi(String s) {
		Automaton automaton = new Automaton();
		for(int i = 0; i < s.length(); i++){
			automaton.get(s.charAt(i));
		}
		return (int)(automaton.ans * automaton.sign);
	}
	
	
	
	/*
	 * �Զ���
	 * 
	 * 				''		+/-		number		other
	 * start		start	signed	in_number	end
	 * signed		end		end		in_number	end
	 * in_number	end		end		in_number	end
	 * end			end		end		end			end
	 * 
	 */

	static class Automaton{
		public int sign = 1;	// ����������������Ǹ�����Ĭ��������
		public long ans = 0;	// ��������������ʽ��Ĭ��Ϊ0
		private String state = "start";	// ��ǰ�Զ�����״̬
		// ʹ��һ��map�����Զ����ĸ���״̬
		private Map<String, String[]> map = new HashMap<String, String[]>(){{
			put("start", new String[]{"start", "signed", "in_number", "end"});
			put("signed", new String[]{"end", "end", "in_number", "end"});
			put("in_number", new String[]{"end", "end", "in_number", "end"});
			put("end", new String[]{"end", "end", "end", "end"});
		}};
		
		
		void get(char c){
			state = map.get(state)[getCol(c)];			
			if("in_number".equals(state)){
				ans = ans * 10 + c - '0';
				ans = sign == 1 ? Math.min((long)Integer.MAX_VALUE, ans) : Math.min(-(long)Integer.MIN_VALUE, ans);
			}else if("signed".equals(state)){
				sign = c == '+' ? 1 : -1;
			}		
		}
		
		int getCol(char c){
			if(c == ' '){
				return 0;
			}
			if(c == '+' || c == '-'){
				return 1;
			}
			if(c >= '0' && c <= '9'){
				return 2;
			}
			return 3;
		}
	}
	
	
	
	
	
	
}
