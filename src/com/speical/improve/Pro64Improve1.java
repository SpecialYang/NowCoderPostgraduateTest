package com.speical.improve;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/** 
* 点菜问题
* 
* bfs也超时哦
* @author special
* @date 2017年12月30日 下午9:29:52
*/
public class Pro64Improve1 {
	
	static int money, n, max;
	
	static class Node{
		int index;
		int sum;
		int score;
		
		public Node(int index, int sum, int score){
			this.index = index;
			this.sum = sum;
			this.score = score;
		}
	}
	
	public static int bfs(int[] prices, int[] grades) {
		int max = Integer.MIN_VALUE;
		Queue<Node> queue = new LinkedList<>();
		for(int i = 0; i < prices.length; i++) {
			queue.offer(new Node(i, prices[i], grades[i]));
		}
		while(!queue.isEmpty()) {
			Node node = queue.remove();
			if(node.sum > money)
				continue;
			if(node.sum <= money) {
				max = Math.max(max, node.score);
			}
			for(int i = node.index + 1; i < prices.length; i++) {
				queue.offer(new Node(i, node.sum + prices[i], node.score + grades[i]));
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			money = input.nextInt();
			n = input.nextInt();
			max = Integer.MIN_VALUE;
			int[] prices = new int[n];
			int[] grades = new int[n];
			for(int i = 0; i < n; i++){
				prices[i] = input.nextInt();
				grades[i] = input.nextInt();
			}
			System.out.println(bfs(prices, grades));
		}
	}

}
