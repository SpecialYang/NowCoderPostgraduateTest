package com.speical.improve;

import java.util.Scanner;

/** 
* 动态规划
* 
* dp[i] = max{dp[i - 1] + dp[i], dp[i]} 表示以i结尾的最大值
* @author special
* @date 2017年12月23日 下午2:20:04
*/
public class Pro21Improve1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			long max = Long.MIN_VALUE;
			long pre = 0;
			long num;
			while(n-- > 0){
				num = input.nextLong();
				pre = Math.max(pre + num, num);
				max = Math.max(max,pre);
			}
			System.out.println(max);
		}
	}
}
