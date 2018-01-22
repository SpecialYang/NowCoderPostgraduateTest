package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月4日 下午3:24:17
*/
public class Pro105 {
	static final int MOD = 100000;
	
	static int[][] dis;
	static boolean[] flag;
	
	public static void getMiniDis(int n, int m){
		int[] cost = new int[n];
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[0] = 0;
		flag[0] = true;
		for(int i = 1; i < n; i++){
			if(!flag[i] && dis[0][i] != 0 
					&& cost[0] + dis[0][i] < cost[i]){
				cost[i] = (cost[0] + dis[0][i]) % MOD;
			}
		}
		int start, min;
		for(int i = 1; i < n; i++){
			start = -1;
			min = Integer.MAX_VALUE;
			for(int j = 0; j < n; j++){
				if(!flag[j] && cost[j] < min){
					start = j;
					min = cost[j];
				}
			}
			if(start == -1) break;
			flag[start] = true;
			for(int j = 0; j < n; j++){
				if(!flag[j] && dis[start][j] != 0 
						&& min + dis[start][j] < cost[j]){
					cost[j] = (min + dis[start][j]) % MOD;
				}
			}
		}
		for(int i = 1; i < n; i++){
			System.out.println(cost[i] == Integer.MAX_VALUE ? -1 : cost[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			dis = new int[n][n];
			flag = new boolean[n];
			int d = 1, src, drc;
			for(int i = 0; i < m; i++){
				src = input.nextInt();
				drc = input.nextInt();
				dis[src][drc] = d;
				dis[drc][src] = dis[src][drc];
				d = (d * 2) % MOD;
			}
			getMiniDis(n,m);
		}
	}

}
