package com.speical.first;

import java.util.Scanner;

/** 
* 采药问题
* 
* 其实就是0 1背包问题
* 
* dp[j] = Math.max(dp[j], dp[j - times[i]] + prices[i]);
* 表示dp[j] j时间能够装的最大价值
* @author special
* @date 2018年1月1日 下午3:19:10
*/
public class Pro73 {
	
	public static int getMaxPrice(int t, int m, int[] times, int[] prices){
		int[] dp = new int[t + 1];
		for(int i = 1; i <= m; i++){
			for(int j = t; j >= times[i]; j--){
				dp[j] = Math.max(dp[j], dp[j - times[i]] + prices[i]);
			}
		}
		return dp[t];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int t = input.nextInt();
			int m = input.nextInt();
			int[] times = new int[m + 1];
			int[] prices = new int[m + 1];
			for(int i = 1; i <= m; i++){
				times[i] = input.nextInt();
				prices[i] = input.nextInt();
			}
			System.out.println(getMaxPrice(t,m,times,prices));
		}
	}

}
