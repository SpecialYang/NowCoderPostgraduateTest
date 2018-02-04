package com.speical.first;

import java.util.Scanner;

/** 
* 查找第K小数（同样大的算一样大）
* 
* 快排的思想好像不可以
* 先留着埋个坑(以后有想法了再过来）
* 
* ------2018.02.04 下午更新-------
* 我真是笨到家了，重复的话，我们去重啊！！！
* @author special
* @date 2018年2月4日 上午11:21:33
*/
public class Pro187 {
	
	private static void exch(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static int partition(int[] nums, int low, int high){
		int i = low, j = high, pivot = nums[low];
		while(i < j){
			while(i <= high && nums[i] <= pivot) { i++; }
			while(j > low && nums[j] >= pivot) { j--; }
			if(i >= j) { break; }
			exch(nums, i , j);
		}
		if(low < j) exch(nums, low , j);
		return j;
	}
	
	public static void getMiniK(int k, int[] nums, int low, int high){
		int point = partition(nums, low, high);
		if(point < k){
			getMiniK(k, nums, point + 1, high);
		}else if(point > k){
			getMiniK(k, nums, low, point);
		}else{
			return;
		}
	}
	
	public static int removeRepeat(int[] nums) {
		int length = 0;
		boolean contains = false;
		for(int i = 0; i < nums.length; i++) {
			contains = false;
			for(int j = 0; j < length; j++) {
				if(nums[j] == nums[i]) {
					contains = true;
					break;
				}
			}
			if(!contains) { nums[length++] = nums[i]; }
		}
		return length;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++){
				nums[i] = input.nextInt();
			}
			int length = removeRepeat(nums);
			int k = input.nextInt();
			getMiniK(k - 1, nums, 0, length - 1);
			System.out.println(nums[k - 1]);
		}
		input.close();
	}

}
