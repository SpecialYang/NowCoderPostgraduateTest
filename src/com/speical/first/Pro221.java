package com.speical.first;

import java.util.Scanner;

/**
 * 大整数排序
 * 
 * 其实字符串排序（我用的是快排）
 * 
 * 思路：
 * 1. 根据字符串的长度即可判断出谁大
 * 2. 若相等，根据字典序即可判断出谁大
 * @author Special
 * @time 2018/02/10 22:10:28
 */
public class Pro221 {
	
	public static void exch(String[] nums, int i, int j) {
		String tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;		
	}
	
	private static boolean less(String str1, String str2) {
		if(str1.length() < str2.length()) {
			return true;
		}else if(str1.length() > str2.length()) {
			return false;
		}else {
//			for(int i = 0;i < str1.length(); i++) {
//				if(str1.charAt(i) < str2.charAt(i)) {
//					return true;
//				}else if(str1.charAt(i) > str2.charAt(i)){
//					return false;
//				}
//			}
			return str1.compareTo(str2) < 0;
		}
	}
	
	public static int partition(String[] nums, int low, int high) {
		int index = low;
		String pivot = nums[high];
		for(int i = low; i < high; i++) {
			if(less(nums[i], pivot)) {
				exch(nums, i, index);
				index++;
			}
		}
		if(index < high) { exch(nums, index, high); }
		return index;
	}
	
	public static void quickSort(String[] nums, int low, int high) {
		if(low < high) {
			int point = partition(nums, low, high);
			quickSort(nums, low, point - 1);
			quickSort(nums, point + 1, high);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			String[] nums = new String[n];
			for(int i = 0; i < n; i++) {
				nums[i] = input.next();
			}
			quickSort(nums, 0, n - 1);
			for(int i = 0; i < n; i++) {
				System.out.println(nums[i]);
			}
		}
	}

}
