package com.speical.improve;

import java.util.Scanner;


/** 
* 最小花费 01背包
* 动态规划
* 
* dp[i] 表示以i结尾的最小花费
* dp[i] = min{dp[0...i - 1] + dp[i]}
* dp[i] 肯定从i - 1中蹦过来
* @author special
* @date 2017年12月23日 下午3:05:45
*/
public class Pro22Improve1 {
	private static int[] dis = new int[3];
	private static int[] price = new int[3];
	
	public static int getMinPrices(int start, int end, int[] tDis){
		int[] dp = new int[end - start + 1];
		for(int i = 1; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;
		for(int i = 1; i < dp.length; i++){
			for(int j = 0; j < i; j++){
				int d = tDis[i + start] - tDis[j + start];
				if(d > dis[2]) continue;
				if(d >= 0 && d <= dis[0]){
					dp[i] = Math.min(dp[j] + price[0], dp[i]);
				}else if(d > dis[0] && d <= dis[1]){
					dp[i] = Math.min(dp[j] + price[1], dp[i]);
				}else{
					dp[i] = Math.min(dp[j] + price[2], dp[i]);
				}
			}
		}
		return dp[end - start];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			for(int i = 0; i < 3; i++){
				dis[i] = input.nextInt();
			}
			for(int i = 0; i < 3; i++){
				price[i] = input.nextInt();
			}
			int start = input.nextInt();
			int end = input.nextInt();
			int N = input.nextInt();
			int[] tDis = new int[N + 1];
			for(int i = 2; i <= N; i++){
				tDis[i] = input.nextInt();
			}
			System.out.println(getMinPrices(start,end,tDis));
		}
	}
}
