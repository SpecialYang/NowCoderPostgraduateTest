package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月4日 下午5:22:57
*/
public class Pro107 {
	public static void exchange(int[] nums, int n){
		for(int i = 0; i < n / 2; i++){
			int temp = nums[i];
			nums[i] = nums[n - i - 1];
			nums[n - i - 1] = temp;
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
			exchange(nums, n);
			for(int i = 0; i < n; i++){
				System.out.print((i == 0 ? "" : " ") + nums[i]);
			}
			System.out.println();
		}
	}

}
