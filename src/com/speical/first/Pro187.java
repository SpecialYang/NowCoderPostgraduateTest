package com.speical.first;

import java.util.Scanner;

/** 
* 查找第K小数（同样大的算一样大）
* 
* 快排的思想好像不可以
* 先留着埋个坑
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
			while(i <= high && nums[i++] <= pivot);
			while(j > low && nums[j--] >= pivot);
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++){
				nums[i] = input.nextInt();
			}
			int k = input.nextInt();
			getMiniK(k - 1, nums, 0, nums.length - 1);
			System.out.println(nums[k - 1]);
		}
	}

}
