package com.speical.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月28日 下午2:14:20
*/
public class Pro48Improve1 {
	static int[][] cost;
	static boolean[] flag;
	static final int MAX = Integer.MAX_VALUE;
	
	public static int getMinCost(){
		int start, min, result = 0;
		int length = flag.length;
		int[] prices = new int[length];
		for(int i = 0; i < length; i++){ //更新所有的prices
			prices[i] = cost[0][i];
		}
		flag[0] = true;
		for(int i = 0; i < length - 1; i++){
			start = -1;
			min = MAX;
			for(int j = 0; j < length; j++){
				if(!flag[j] && prices[j] < min){
					start = j;
					min = prices[j];
				}
			}
			if(min == MAX) break;
			flag[start] = true;
			result += min;
			for(int j = 0; j < length; j++){
				if(!flag[j] && cost[start][j] < prices[j]){
					prices[j] = cost[start][j];
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int lines = input.nextInt();
			if(lines == 0) break;
			cost = new int[lines][lines];
			flag = new boolean[lines];
			for(int i = 0; i < lines; i++){
				for(int j = 0; j < lines; j++){
					cost[i][j] = i == j ? 0 : MAX; //关键！
				}
			}
			for(int i = 0; i < lines - 1; i++){
				int start = input.next().charAt(0) - 'A';
				int k = input.nextInt();
				while(k-- > 0){
					int end = input.next().charAt(0) - 'A';					
					int price = input.nextInt();
					if(price < cost[start][end]){ //关键！防止有重复的边覆盖最小值
						cost[start][end] = price;
						cost[end][start] = price;
					}
				}
			}
			System.out.println(getMinCost());
		}
	}
}
