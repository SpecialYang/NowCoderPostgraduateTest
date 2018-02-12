package com.speical.first;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 
* 最小花费
* 
* bfs 你们仅仅学习一下思想吧
* java竟然超时，c++没试
* @author special
* @date 2017年12月23日 下午2:36:19
*/
public class Pro22 {
	private static int[] dis = new int[3];
	private static int[] price = new int[3];
	
	static class Node{
		int index;
		int sum;
		public Node(int index, int sum){
			this.index = index;
			this.sum = sum;
		}
	}
	public static int bfs(int start, int end, int[] tDis){
		int min = Integer.MAX_VALUE;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start, 0));
		while(!queue.isEmpty()){
			Node node = queue.remove();
			if(node.index == end){
				min = Math.min(min,node.sum);
				continue;
			}
			for(int i = node.index + 1; i <= end; i++){
				int d = tDis[i] - tDis[node.index];
				if(d > dis[2]) break;
				if(d >= 0 && d <= dis[0]){
					queue.offer(new Node(i, node.sum + price[0]));
				}else if(d > dis[0] && d <= dis[1]){
					queue.offer(new Node(i, node.sum + price[1]));
				}else{
					queue.offer(new Node(i, node.sum + price[2]));
				}
			}
		}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			for(int i = 0; i < 3; i++){
				dis[i] = input.nextInt();
			}
			for(int i = 0; i < 3; i++){
				price[i] = input.nextInt();
			}
			int start = input.nextInt();
			int end = input.nextInt();
			int N = input.nextInt();
			int[] tDis = new int[N + 1];
			for(int i = 2; i <= N; i++){
				tDis[i] = input.nextInt();
			}
			System.out.println(bfs(start,end,tDis));
		}
	}

}
