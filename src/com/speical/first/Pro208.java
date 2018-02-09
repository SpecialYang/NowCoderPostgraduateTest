package com.speical.first;

import java.util.Scanner;

/**
 * 希尔排序
 * 
 * 坑 ：如果n == 1，还要再输出个-1
 * @author Special
 * @time 2018/02/09 10:44:22
 */
public class Pro208 {
	
	/**
	 * 注意步长的选取
	 * @param nums
	 */
	public static void XierSort(int[] nums) {
		int steps = nums.length / 3 + 1;
		while(steps > 0) {
			for(int i = steps; i < nums.length; i++) {
				for(int j = i; j >= steps && nums[j] > nums[j - steps]; j--) {
					int temp = nums[j];
					nums[j] = nums[j - steps];
					nums[j - steps] = temp;
				}
			}
			steps--;
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
			XierSort(nums);
			if(n > 0) {
				System.out.println(nums[0]);
			}
			if(n > 1) {
				for(int i = n - 1; i > 0; i--) {
					System.out.print((i == n - 1 ? "" : " ") + nums[i]);
				}
			}
			else if(n == 1) {
				System.out.print("-1");
			}
			System.out.println();
		}
	}

}
