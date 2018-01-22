package com.speical.first;

import java.util.Scanner;

/** 
* 最长递减子序列长度（这里可以等于）
* 
* 2种思路：
* 可以从末尾开始求最长递增序列
* 也可以直接从开头求最长递减序列
* @author special
* @date 2018年1月1日 下午3:52:04
*/
public class Pro75 {
	
	public static int getMaxCount(int[] height, int length){
		int[] dp = new int[length + 1];
		int max = 0;                   
		for(int i = 1; i <= length; i++) dp[i] = 1;
		for(int i = length; i >= 1; i--){       //从末尾开始求最长递增序列
			for(int j = length; j > i; j--){
				if(height[j] <= height[i]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);   //求max放在内循环外面好一点啊
		}
		/*for(int i = 1; i <= length; i++){      //从开头求最长递减序列
			for(int j = 1; j < i; j++) {
				if(height[j] >= height[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}*/
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] height = new int[n + 1];
			for(int i = 1; i <= n; i++){
				height[i] = input.nextInt();
			}
			System.out.println(getMaxCount(height, n));
		}
	}

}
