package com.speical.improve;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/** 
* dfs的做法溢出了！！！！
* 谁能优化一下
* @author special
* @date 2017年12月21日 下午2:50:00
*/
public class Pro11Improve1 {
	private static final String mapStr = "2012";
	private static char[] nums;
	private static int minCount;
	private static Set<String> sets;
	
	private static boolean isContains(char[] nums){
		int index;
		for(int i = 0; i < nums.length - 3; i++){
			index = 0;
			while(nums[i] == mapStr.charAt(index)){
				i++;
				index++;
				if(index == 4) return true;
			}
		}
		return false;
	}
	private static void swap(char[] chars, int i, int j){
		char ch = chars[i];
		chars[i] = chars[j];
		chars[j] = ch;
	}
	/**
	 * dfs
	 * 因为每个节点要么与前一个交换，要么与后一个交换,要么不交换
	 * @param n
	 * @param str
	 * @return
	 */
	private static void dfs(int index, int count, char[] nums){
		if(isContains(nums)){
			if(count < minCount) minCount = count;
			return;
		}
		if(index >= 1){
			char[] temp = Arrays.copyOf(nums, nums.length);
			swap(temp,index - 1,index);
			String tempStr = new String(temp);
			if(!sets.contains(tempStr)){
				sets.add(tempStr);
				dfs(index - 1,count + 1, temp);
			}
		}if(index < nums.length - 1){
			char[] temp = Arrays.copyOf(nums, nums.length);
			swap(temp,index,index + 1);
			String tempStr = new String(temp);
			if(!sets.contains(tempStr)){
				sets.add(tempStr);
				dfs(index + 1,count + 1, temp);
			}
			dfs(index + 1, count, nums);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			nums = input.next().toCharArray();
			minCount = Integer.MAX_VALUE;
			sets = new HashSet<>();
			sets.add(new String(nums));
			dfs(0,0,nums);
			if(minCount == Integer.MAX_VALUE){
				System.out.println(-1);
			}else{
				System.out.println(minCount);				
			}
		}
	}
}
