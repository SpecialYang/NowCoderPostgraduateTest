package com.speical.first;

import java.util.Scanner;

/** 
* dfs超时代码
* 
* 敲的过程中就感觉要超时，哈哈
* 就是不服输，就是要试试
* 
* 正确的做法是 0 1 背包
* @author special
* @date 2017年12月30日 下午9:17:06
*/
public class Pro64 {
	
	static int[] prices, grades;
	static int money, n, max;
	
	public static void dfs(int index, int sum, int score){
		if(sum > money) return;
		if(sum <= money){
			max = Math.max(max,score);
		}
		for(int i = index; i < n; i++){
			dfs(i + 1, sum + prices[i], score + grades[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			money = input.nextInt();
			n = input.nextInt();
			max = Integer.MIN_VALUE;
			prices = new int[n];
			grades = new int[n];
			for(int i = 0; i < n; i++){
				prices[i] = input.nextInt();
				grades[i] = input.nextInt();
			}
			dfs(0,0,0);
			System.out.println(max);
		}
	}

}
