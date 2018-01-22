package com.speical.improve;

import java.util.Scanner;

/** 
* 放苹果
* 
* 动态规划
* dp[j] = dp[j] + dp[j - i]; 
* 其中第一项为j个苹果放比现在少一个盘子的种树
* 第二项为现在的盘子都放苹果
* @author special
* @date 2018年1月1日 下午2:37:03
*/
public class Pro60Improve1 {
	public static int getKinds(int m, int n){
		int[] dp = new int[m + 1];
		dp[0] = 1;
		for(int i = 1; i <= n; i++){
			for(int j = i; j <=m; j++){
				dp[j] = dp[j] + dp[j - i];
			}
		}
		return dp[m];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			System.out.println(getKinds(m,n));
		}
	}

}
