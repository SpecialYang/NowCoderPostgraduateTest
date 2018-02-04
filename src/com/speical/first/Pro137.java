package com.speical.first;

import java.util.Scanner;

/** 
* dfs超时了！！！！
* 
* 
* @author special
* @date 2018年1月22日 上午9:04:43
*/
public class Pro137 {
	static boolean[] flag;
	static int maxPrice;
	static Node[] nodes; 
	
	static class Node{
    	int price;
    	int lateStartTime;
    	int duration;
    	
    	public Node(int price, int lateStartTime, int duration){
    		this.price = price;
    		this.lateStartTime = lateStartTime;
    		this.duration = duration;
    	}
    }
    public static void dfs(int price, int time){
    	boolean isEnd = true;
    	for(int i = 0; i < flag.length; i++){
    		if(!flag[i] && time <= nodes[i].lateStartTime){
    			isEnd = false;
    			flag[i] = true;
    			dfs(price + nodes[i].price, time + nodes[i].duration);
    			flag[i] = false;
    		}
    	}
    	if(isEnd){  // 判断是否结束
    		maxPrice = Math.max(maxPrice, price);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == -1) break;
			nodes = new Node[n];
			flag = new boolean[n];
			maxPrice = Integer.MIN_VALUE;
			
			int price, duration, end;
			for(int i = 0; i < n; i++){
				price = input.nextInt();
				duration = input.nextInt();
				end = input.nextInt();
				nodes[i] = new Node(price, end - duration, duration);
			}
			dfs(0,0);
			System.out.println(maxPrice);
		}
	}

}
