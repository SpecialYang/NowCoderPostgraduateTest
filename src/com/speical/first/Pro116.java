package com.speical.first;

import java.util.Scanner;

/** 
* 最小生成树（代价最小）
* 
* 最简单的实现，复杂度有点高，但思想对
* @author special
* @date 2018年1月5日 下午1:19:41
*/
public class Pro116 {
	static int[][] dis;
	static boolean[] flag;
	static final int MAX = Integer.MAX_VALUE;
	
	public static int getMinCost(int n){
		int cost = 0;
		flag[0] = true;
		int count = n - 1, start, min;
		while(count-- > 0){
			start = -1;
			min = MAX;
			for(int i = 0; i < n; i++){
				if(flag[i]){
					for(int j = 0; j < n; j++){
						if(!flag[j] && dis[i][j] < min){
							start = j;
							min = dis[i][j];
						}
					}
				}
			}
			flag[start] = true;
			cost += min;
		}
		return cost;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			dis = new int[n][n];
			flag = new boolean[n];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					dis[i][j] = i == j ? 0 : MAX; 
				}
			}
			int src, drc, cost, build;
			for(int i = 0; i < n * (n - 1) / 2; i++){
				src = input.nextInt() - 1;
				drc = input.nextInt() - 1;
				cost = input.nextInt();
				build = input.nextInt();
				dis[src][drc] = build == 0 ? cost : 0;
				dis[drc][src] = dis[src][drc];
			}
			System.out.println(getMinCost(n));
		}
	}

}
