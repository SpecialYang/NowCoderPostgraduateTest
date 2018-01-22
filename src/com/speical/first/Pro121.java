package com.speical.first;

import java.util.Scanner;

/** 
* 寻找大富翁
* 
* 对于给定的m
* 寻找topM, m次选择排序最简单
* @author special
* @date 2018年1月6日 上午10:07:58
*/
public class Pro121 {
	public static void findTopM(int[] nums, int n, int m){
		int max;
		for(int i = 0; i < m; i++){
			max = i;
			for(int j = i + 1; j < n; j++){
				if(nums[j] > nums[max]){
					max = j;
				}
			}
			if(max != i){
				int temp = nums[i];
				nums[i] = nums[max];
				nums[max] = temp;
			}
		}
		for(int i = 0; i < m; i++){
			System.out.print((i == 0 ? "" : " ") + nums[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			if(n == 0 && m == 0) break;
			int[] nums = new int[n];
			for(int i = 0; i < n; i++){
				nums[i] = input.nextInt();
			}
			findTopM(nums,n,Math.min(n, m));
		}
	}

}
