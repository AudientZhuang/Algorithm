package com.audient._435;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class FirstSolution {
	
	public static void main(String[] args) {
		int[][] intervals = {{1,4},{2,3},{3,4}};
		int result = eraseOverlapIntervals(intervals);
		System.out.println(result);
	}
	
	static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1){
        	return 0;
        }
		
		// 对区间集合进行排序
		Arrays.sort(intervals, new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]){
					return (o1[1] - o1[0]) - (o2[1] - o2[0]);
				}
				return o1[0] - o2[0];
			}

		});
		
		for(int i = 0; i < intervals.length; i++){
			System.out.println(intervals[i][0] + "," + intervals[i][1]);
		}
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(intervals[0]);
		for(int i = 1; i < intervals.length; i++){
			if(intervals[i][0] == intervals[i - 1][0]){
				continue;
			}
			list.add(intervals[i]);
		}
		if(list.size() == 1){
			return intervals.length - list.size();
		}
		
		int index = 0;	// 当前索引
		
		
		
		
		/*Iterator<int[]> iterator = list.iterator();
		int[] item = iterator.next();
		while(iterator.hasNext()){
			
			
		}
	
		while(iterator.hasNext()){
			int[] temp = iterator.next();
			if(temp[0] < item[1]){
				iterator.remove();
			}else{
				item = temp;
			}
		}*/
		
		return intervals.length - list.size();
    }

}
