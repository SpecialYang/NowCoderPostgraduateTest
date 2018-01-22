package com.speical.first;

import java.util.Scanner;

/** 
* 畅通工程
* 
* 求最少再添加几条路，才能是各个村庄互通
* 
* 其实就是求出联通块的数目，然后联通块 - 1就是最小的条数
* 只要用某种遍历方式。遍历图即可。当遍历结束，但是还有点没遍历时
* 就另选一个没有访问的过的节点继续遍历即可
* 
* 我这里是dfs遍历，当然你也可以bfs, 甚至层序
* @author special
* @date 2018年1月6日 下午1:52:28
*/
public class Pro124 {
	static boolean[][] dis;
	static boolean[] flag;
	
	public static void dfs(int index){
		for(int i = 0; i < flag.length; i++){
			if(dis[index][i] && !flag[i]){
				flag[i] = true;
				dfs(i);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			int m = input.nextInt();
			dis = new boolean[n][n];
			flag = new boolean[n];
			int src, drc;
			for(int i = 0; i < m; i++){
				src = input.nextInt() - 1;
				drc = input.nextInt() - 1;
				dis[src][drc] = true;
				dis[drc][src] = dis[src][drc];
			}
			int result = 0;
			for(int i = 0; i < n; i++){
				if(!flag[i]){
					flag[i] = true;
					dfs(i);
					result++;
				}
			}
			System.out.println(result - 1);
		}
	}

}
