package com.speical.improve;

import java.util.Scanner;

/** 
* 0 1 背包问题
* 
* 状态转移方程：
* dp[i][j] 表示为价钱为j时只取前i个物品时的最大得分
* dp[i][j] = dp[i - 1][j] ( j < price[i])
* dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - prices[i]] + grades[i]); ( j >= price[i])
* 
* 
* @author special
* @date 2017年12月30日 下午10:37:08
*/
public class Pro64Improve2 {
	static int[] prices, grades;
	static int money, n;
	
	public static int dp(){
		int[][] dp = new int[n + 1][money + 1];
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= money; j++){
				dp[i][j] = dp[i - 1][j];
				if(j >= prices[i]){
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - prices[i]] + grades[i]);
				}
			}
		}
		return dp[n][money];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			money = input.nextInt();
			n = input.nextInt();
			prices = new int[n + 1];
			grades = new int[n + 1];
			for(int i = 1; i <= n; i++){
				prices[i] = input.nextInt();
				grades[i] = input.nextInt();
			}
			System.out.println(dp());
		}
	}
}
