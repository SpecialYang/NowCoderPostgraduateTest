package com.speical.first;

import java.util.Scanner;

/** 
* 判断无向图的连图
* 
* 只需利用一种遍历方式从一个节点出发
* 记录访问过的节点数，若最后访问的节点数等于总节点数
* 那么肯定是连通，否则存在多个连通块
* @author special
* @date 2018年2月1日 上午11:24:36
*/
public class Pro172 {
	static boolean[][] isConnective;
	static boolean visited[];
	static int n, nodes;
	
	public static void dfs(int index){
		for(int i = 0; i < n; i++){
			if(isConnective[index][i] && !visited[i]){
				visited[i] = true;
				nodes++;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			n = input.nextInt();
			int m = input.nextInt();
			isConnective = new boolean[n][n];
			visited = new boolean[n];
			nodes = 0;
			int src, drc;
			while(m-- > 0){
				src = input.nextInt() - 1;
				drc = input.nextInt() - 1;
				isConnective[src][drc] = true;
				isConnective[drc][src] = true;
			}
			visited[0] = true;
			nodes++;
			dfs(0);
			System.out.println(nodes == n ? "YES" : "NO");
		}
	}

}
