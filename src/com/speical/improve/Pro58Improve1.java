package com.speical.improve;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月30日 下午2:51:09
*/
public class Pro58Improve1 {
	
	final static int SIZE = 40;
	
	static class Node{
		int index;
		int sum;
		public Node(int index, int sum){
			this.index = index;
			this.sum = sum;
		}
	}
	/**
	 * 层序遍历
	 * 注意初始化要把单个体积全部进入队列
	 * 否则之后都是包含第一个物体的体积的方案
	 * @param weights
	 * @return
	 */
    public static int bfs(int[] weights){
    	int kinds = 0;
    	Queue<Node> queue = new LinkedList<>();
    	for(int i = 0; i < weights.length; i++){
    		queue.offer(new Node(i,weights[i]));
    	}
    	while(!queue.isEmpty()){
    		Node node = queue.remove();
    		if(node.sum > SIZE) continue;
    		if(node.sum == SIZE){
    			kinds++;
    			continue;
    		}
    		for(int i = node.index + 1; i < weights.length; i++){
    			queue.offer(new Node(i, node.sum + weights[i]));
    		}
    	}
    	return kinds;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] weights = new int[n];
			for(int i = 0; i < n; i++){
				weights[i] = input.nextInt();
			}
			System.out.println(bfs(weights));
		}
	}
}
