package com.speical.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


/** 
* 最短距离问题（过桥）
* 
* bfs果然超时了，思想应该是对，样例都对了
* 
* 我明白bfs在这里不适合的原因，因为bfs每次都考察走一步的结果
* 但是这里我们要求得不是最短步数，而是最小代价，可能出现走2步的结果最优的状况
* c++不知道
* 
* 更新：这次我改用了邻接表，过了80%。
* 怎么能解决bfs过程中保证每个节点访问一次，避免数组复制
* @author special
* @date 2017年12月24日 上午10:55:38
*/
public class Pro27 {
	private static List<List<Node>> dis;
	private static int[] support;
	
	static class Node{
		int index;
		int dis;
		public Node(int index, int dis){
			this.index = index;
			this.dis = dis;
		}
	}
	
	static class Status{
		int index; //到达目标地点
		int cost;  //当前花费
		int[] flag; //走过了哪些节点
		int sup;
		public Status(int index, int cost, int[] flag, int sup){
			this.index = index;
			this.cost = cost;
			this.flag = flag;
			this.sup = sup;
		}
	}
	public static int bfs(int src, int drc){
		int min = Integer.MAX_VALUE;
		int length = support.length;
		Queue<Status> queue = new LinkedList<>();
		int[] flag = new int[length];
		flag[src] = 1;
		queue.offer(new Status(src,0,flag,support[1]));
		while(!queue.isEmpty()){
			Status status = queue.remove();
			if(status.cost >= min) continue;
			if(status.index == drc){
				min = Math.min(min,status.cost);
				continue;
			}
			List<Node> wedges = dis.get(status.index);
			for(int i = 0; i < wedges.size(); i++){
				Node node = wedges.get(i);
				if(status.flag[node.index] != 1 && support[node.index] >= status.sup){
					int[] temp = Arrays.copyOf(status.flag, length);
					temp[node.index] = 1;
					queue.offer(new Status(node.index, status.cost + node.dis, temp, support[node.index]));
				}
			}
		}
		return min;
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
			int result = bfs(1, 2);
			System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		}
	}
}
