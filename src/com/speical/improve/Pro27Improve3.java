package com.speical.improve;

import java.util.Scanner;

/** 
* 带约束的最短路径算法
* 
* 为什么就是过不了呢？？？？
* @author special
* @date 2017年12月24日 下午3:40:56
*/
public class Pro27Improve3 {
	static final int MAX = 100000000;
	static int[][] dis;
	static int[] cost, support;
	static boolean[] flag;
	
	/**
	 * 最短路径算法
	 * 带约束的
	 * 
	 * @param src
	 * @param drc
	 */
	public static void dijkral(int src, int drc){
		cost[src] = 0;
		int length = support.length;
		for(int i = 1; i < length; i++){
			int start = -1;
			int min = MAX;
			for(int j = 1; j < length; j++){
				if(!flag[j] && cost[j] < min){
					start = j;
					min = cost[j];
				}
			}
			if(start == drc || start == -1) return;
			flag[start] = true;
			for(int k = 1; k < length; k++){
				if(!flag[k] && min + dis[start][k] < cost[k] 
						&& support[k] >= support[start]){
					cost[k] = min + dis[start][k];
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			dis = new int[n + 1][n + 1];
			support = new int[n + 1];
			flag = new boolean[n + 1];
			cost = new int[n + 1];
			
			for(int i = 1; i <= n; i++) 
				cost[i] = MAX;
			for(int i = 1; i <= n; i++)
				for(int j = 1; j <= n; j++)
					dis[i][j] = MAX;
			int roads = input.nextInt();
			int src,drc;
			while(roads-- > 0){
				src = input.nextInt();
				drc = input.nextInt();
				dis[src][drc] = input.nextInt();
				dis[drc][src] = dis[src][drc];
			}
			for(int i = 1; i <= n; i++){
				support[i] = input.nextInt();
			}
			dijkral(1,2);
			System.out.println(cost[2] == MAX ? -1 : cost[2]);
		}
		
	}

}
