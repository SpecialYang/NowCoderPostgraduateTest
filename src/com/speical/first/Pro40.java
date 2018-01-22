package com.speical.first;

import java.util.Scanner;

/** 
* 放苹果问题
* dp[i][j] = dp[i - j][j] + dp[i][j - 1];
* 如果i < j, 也就是说苹果比盘子少，那么dp[i][j] = dp[i][i];
* 
* 另一种动态规划的思想就是：
* dp[i][j] = dp[i][j - 1] + (i < j ? 0 : dp[i - j][j]);
* 也就是说当苹果比盘子少时，dp[i][j] = dp[i][j - 1] + 0;
* 也就是3个苹果放5个盘子与 3个苹果放4个盘子种树一样
* @author special
* @date 2017年12月26日 下午11:33:37
*/
public class Pro40 {
	public static int getKinds(int m, int n){
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 1; i <= n; i++) dp[0][i] = 1;
		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(i >= j){
					dp[i][j] = dp[i - j][j] + dp[i][j - 1];
				}else {
					dp[i][j] = dp[i][i];
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				System.out.println(getKinds(input.nextInt(),input.nextInt()));
			}
		}
	}

}
