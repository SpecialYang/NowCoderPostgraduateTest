package com.speical.first;

import java.util.Scanner;

/** 
* 最长子序列和
* 
* 其实又是最长递增子序列长度的变形
* 以前记录的长度，此时不过记录的是的值的和
* @author special
* @date 2018年1月1日 下午4:32:31
*/
public class Pro76 {
	
	public static int getMaxSum(int[] nums, int n){
		int[] dp = new int[n + 1];
		int max = 0;
		for(int i = 1; i <= n; i++) dp[i] = nums[i];
		for(int i = 1; i <= n; i++){
			for(int j = 1; j < i; j++){
				if(nums[j] < nums[i]){
					dp[i] = Math.max(dp[i], dp[j] + nums[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] nums = new int[n + 1];
			for(int i = 1; i <= n; i++){
				nums[i] = input.nextInt();
			}
			System.out.println(getMaxSum(nums, n));
		}
	}

}
