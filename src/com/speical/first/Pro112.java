package com.speical.first;

import java.util.Scanner;

/** 
* 最长公共子序列问题
* dp[i][j] 表示串1的前i个与串2的前j个最长的子序列长度
* 
* dp[i][j] = dp[i - 1][j - 1] + 1;
* dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
* @author special
* @date 2018年1月5日 上午9:58:23
*/
public class Pro112 {
	
	public static int getLongestCommonSubsequence(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];
		for(int i = 1; i <= length1; i++){
			for(int j = 1; j <= length2; j++){
				if(str1.charAt(i - 1) == str2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[length1][length2];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			System.out.println(getLongestCommonSubsequence(str1, str2));
		}
	}

}
