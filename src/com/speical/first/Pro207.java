package com.speical.first;

import java.util.Scanner;

/**
 * 快速排序呀
 * @author Special
 * @time 2018/02/09 10:28:02
 */
public class Pro207 {
	
	private static void exch(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	/**
	 * 划分的另一种思路
	 * @param nums
	 * @param low
	 * @param high
	 * @return
	 */
	private static int partition(int[] nums, int low, int high) {
		int index = low;
		for(int i = low; i < high; i++) {
			if(nums[i] < nums[high]) {
				exch(nums, index, i);
				index++;
			}
		}
		if(index < high) { exch(nums, high, index); }
		return index;
	}
	
	public static void quickSort(int[] nums, int low, int high) {
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
			int[] nums = new int[n];
			for(int i = 0; i < n; i++) {
				nums[i] = input.nextInt();
			}
			quickSort(nums, 0, nums.length - 1);
			for(int i = 0; i < n; i++) {
				System.out.print((i == 0 ? "" : " ") + nums[i]);
			}
			System.out.println();
		}
	}

}
