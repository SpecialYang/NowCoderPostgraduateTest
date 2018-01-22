package com.speical.first;

import java.util.Scanner;

/** 
* 畅通工程问题（跟116一样，都是最小生成树问题）
* 
* 注意在对村庄进行赋值代价的时候，应该考虑一下当前的代价是否小于之前的记录
* 否则会导致覆盖掉两个村庄间的最小代价（因为村庄可能存在多条道路）
* 
* dis[src][drc] = cost < dis[src][drc] ? cost : dis[src][drc];
* @author special
* @date 2018年1月5日 下午1:41:29
*/
public class Pro117 {
	static int[][] dis;
	static boolean[] flag;
	static final int MAX = Integer.MAX_VALUE;
	
	public static int getMinCost(int m){
		int costs = 0;
		flag[0] = true;
		int count = m - 1, start, min;
		while(count-- > 0){
			start = -1;
			min = MAX;
			for(int i = 0; i < m; i++){
				if(flag[i]){
					for(int j = 0; j < m; j++){
						if(!flag[j] && dis[i][j] < min){
							start = j;
							min = dis[i][j];
						}
					}
				}
			}
			if(start == -1) return min;
			flag[start] = true;
			costs += min;
		}
		return costs;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			if(n == 0) break;
			dis = new int[m][m];
			flag = new boolean[m];
			for(int i = 0; i < m; i++){
				for(int j = 0; j < m; j++){
					dis[i][j] = i == j ? 0 : MAX;
				}
			}
			int src, drc, cost;
			for(int i = 0; i < n; i++){
				src = input.nextInt() - 1;
				drc = input.nextInt() - 1;
				cost = input.nextInt();
				dis[src][drc] = cost < dis[src][drc] ? cost : dis[src][drc];
				dis[drc][src] = dis[src][drc];
			}
			int costs = getMinCost(m);
			System.out.println(costs == MAX ? "?" : costs);
		}
	}

}
