package com.speical.first;

import java.util.Scanner;

/** 
* 把数分成2的蜜的组成部分
* 
* dfs栈溢出！
* @author special
* @date 2017年12月20日 上午8:51:11
*/
public class Pro07 {
	private static int n;
	private static int count;
	private static final int MOD = 1000000000;
	public static void dfs(int item, int sum){
		if(sum >= n){
			if(sum == n){
				count = (count + 1) % MOD;
			}
			return;
		}
		for(int i = 0; i < 32; i++){
			int temp = 1 << i;
			if(temp >= item){
				dfs(temp, sum + temp);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			n = input.nextInt();
			count = 0;
			dfs(0,0);
			System.out.println(count);
		}
	}

}
