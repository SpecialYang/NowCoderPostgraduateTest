package com.speical.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年2月4日 上午11:59:22
*/
public class Pro187Improve1 {
	
	private static void exch(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private static int partition(int[] nums, int low, int high){
		int i = low, j = high, pivot = nums[low];
		while(i < j){
			while(i <= high && nums[i++] >= pivot);
			while(j > low && nums[j--] <= pivot);
			if(i >= j) break;
			exch(nums, i, j);
		}
		if(low < j) exch(nums, low , j);
		return j;
	}
	
	public static void quickSort(int[] nums, int low, int high){
		if(low < high){
			int pivot = partition(nums, low, high);
			quickSort(nums, low, pivot - 1);
			quickSort(nums, pivot + 1, high);
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
			quickSort(nums, 0, nums.length - 1);
			for(int i = 0; i < n; i++){
				
			}
		}
	}

}
