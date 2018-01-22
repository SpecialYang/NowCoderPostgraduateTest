package com.speical.improve;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 用ArraList优化了一下，这样就不用遍历所有的数组了
* 
* 注意ArraList的remove方法的两个重载
* remove(int index) 删除指定位置的元素
* remove(Object object) 删除值为object的元素，
* 如果元素是原始类型，要注意手动转型为包装类型
* @author special
* @date 2017年12月26日 下午11:19:27
*/
public class Pro39Improve1 {

	static Node[] nodes;
	static double MAX = Double.MAX_VALUE;
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
		List<Integer> done = new ArrayList<>();
		List<Integer> unDone = new ArrayList<>();
		for(int i = 0; i < n; i++){
			unDone.add(i);
		}
		done.add(0);
		unDone.remove((Integer) 0);
		while(unDone.size() > 0){
			int start = -1;
			double min = MAX;
			for(int i = 0; i < done.size(); i++){
				for(int j = 0; j < unDone.size(); j++){
					if(dis[done.get(i)][unDone.get(j)] < min){
						start = unDone.get(j);
						min = dis[done.get(i)][unDone.get(j)];
					}
				}
			}
			done.add(start);
			unDone.remove((Integer) start);
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
