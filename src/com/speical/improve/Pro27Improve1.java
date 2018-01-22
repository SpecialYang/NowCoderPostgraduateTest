package com.speical.improve;

import java.util.Scanner;


/** 
* dfs尝试也过不了。。。。。
* 邻接矩阵过不了，那么我之后试试邻接表如何？
* 因为在图模型中，一个节点的各个邻接点可以扩展很大，所以会造成纵向无限下去！
* @author special
* @date 2017年12月24日 上午11:56:20
*/
public class Pro27Improve1 {
	private static int[][] dis;
	private static int[] support;
	private static int min, drc = 2;
	private static boolean[] flag;
	
	public static void dfs(int index, int cost, int sup){
		if(cost >= min) return;
		if(index == drc){
			min = Math.min(min,cost);
			return;
		}
		for(int i = 2; i < dis.length; i++){
			if(dis[index][i] != 0 && !flag[i] && support[i] >= sup){
				flag[i] = true;
				dfs(i, cost + dis[index][i], support[i]);
				flag[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			dis = new int[n + 1][n + 1];
			support = new int[n + 1];
			flag = new boolean[n + 1];
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
			min = Integer.MAX_VALUE;
			flag[1] = true;
			dfs(1, 0, support[1]);
			System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		}
	}
}
