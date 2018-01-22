package com.speical.improve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* dfs做法
* 用邻接矩阵没有过啊 , 改用邻接表救过了
* 
* 保证只过了一次桥，利用待考察的所属于的leader的大小大于等于当前的leader即可
* @author special
* @date 2017年12月24日 下午2:08:48
*/
public class Pro27Improve2 {
	
	private static List<List<Node>> dis;
	private static int[] support;
	private static int min, drc = 2;
	private static boolean[] flag;
	
	static class Node{
		int index;
		int dis;
		public Node(int index, int dis){
			this.index = index;
			this.dis = dis;
		}
	}
	public static void dfs(int index, int cost, int sup){
		if(cost >= min) return;
		if(index == drc){
			min = Math.min(min,cost);
			return;
		}
		List<Node> wedges = dis.get(index);
		for(int i = 0; i < wedges.size(); i++){
			Node node = wedges.get(i);
			if(!flag[node.index] && support[node.index] >= sup){
				flag[node.index] = true;
				dfs(node.index, cost + node.dis, support[node.index]);
				flag[node.index] = false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			dis = new ArrayList<>();
			for(int i = 0; i <= n; i++){
				dis.add(new ArrayList<Node>());
			}
			support = new int[n + 1];
			flag = new boolean[n + 1];
			int roads = input.nextInt();
			int src,drc,cost;
			while(roads-- > 0){
				src = input.nextInt();
				drc = input.nextInt();
				cost = input.nextInt();
				dis.get(src).add(new Node(drc, cost));
				dis.get(drc).add(new Node(src, cost));
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
