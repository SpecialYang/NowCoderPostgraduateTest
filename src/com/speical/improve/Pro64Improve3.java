package com.speical.improve;

import java.util.Scanner;

/** 
* 背包问题简单版
* 
* dp[j]表示j空间能装多重的东西
* dp[j] = Math.max(dp[j],dp[j - prices[i]] + scores[i]);
* 
* 这里之所以不  从小考虑到大， 是因为我们一次循环的之后判断可能用到之前的值了，这是不对的
* 一个背包只能装一个这样的东西啊
* 比如 dp[50] 我们算出来应该最大为20，等我们考虑到dp[100],正常应该是dp[100] = 20
* 但是会用到之前的结果，而导致算出来为dp[100] = 40
* 
* @author special
* @date 2017年12月30日 下午11:40:18
*/
public class Pro64Improve3 {
	public static int getMaxScore(int c, int n, int[] prices, int[] scores){
		int[] dp = new int[c + 1];
		for(int i = 1; i <= n; i++){
			for(int j = c; j >= prices[i]; j--){
				dp[j] = Math.max(dp[j],dp[j - prices[i]] + scores[i]);
			}
		}
		return dp[c];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int c = input.nextInt();
			int n = input.nextInt();
			int[] prices = new int[n + 1];
			int[] scores = new int[n + 1];
			for(int i = 1; i <= n; i++){
				prices[i] = input.nextInt();
				scores[i] = input.nextInt();
			}
			System.out.println(getMaxScore(c,n,prices,scores));
		}
	}

}
