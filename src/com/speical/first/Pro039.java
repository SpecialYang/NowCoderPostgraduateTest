package com.speical.first;

import java.util.Scanner;

/** 
* 最小生成树
* 
* 我这里实现的是复杂度为n的平方
* 首先把节点分成2部分，一部分是已添加节点，另一部分是未添加节点
* 首先我们假设从0节点开始，flag[0] = true;
* 然后对于已添加的节点求到未添加节点的最短距离
* 记录最短距离时的值和对应的节点索引start
* 把start添加进来，即flag[start] = true;
* 直到未添加节点为0，结束
* 
* 因为这个题每次必然能选择一个节点，所以我们直接每次遍历个数减一来控制结束条件
* @author special
* @date 2017年12月26日 下午9:59:59
*/
public class Pro39 {
	static Node[] nodes;
	static double MAX = Double.MAX_VALUE;
	static boolean[] flag;
	static double[][] dis;
	
	static class Node{
		double x;
		double y;
		public Node(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	
	private static double dis(int i, int j){
		return Math.sqrt((nodes[i].x - nodes[j].x) * (nodes[i].x - nodes[j].x)
				+ (nodes[i].y - nodes[j].y) * (nodes[i].y - nodes[j].y));
	}
	
	public static double getMinCost(){
		double result = 0;
		int n = nodes.length;
		flag[0] = true;
		while(--n > 0){
			int start = -1;
			double min = MAX;
			for (int i = 0; i < nodes.length; i++) {
				if(flag[i]){
					for (int j = 0; j < nodes.length; j++) {
						if (!flag[j] && dis[i][j] < min) {
							start = j;
							min = dis[i][j];
						}
					}
				}
			}
			flag[start] = true;
			result += min;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			nodes = new Node[n];
			flag = new boolean[n];
			dis = new double[n][n];
			for(int i = 0; i < n; i++){
				nodes[i] = new Node(input.nextDouble(),input.nextDouble());
			}
			for(int i = 0; i < n - 1; i++){
				for(int j = i + 1; j < n; j++){
					dis[i][j] = dis(i, j);
					dis[j][i] = dis[i][j];
				}
			}
			System.out.format("%.2f", getMinCost());
		}
	}

}
