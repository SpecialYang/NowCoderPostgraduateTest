package com.speical.improve;

import java.util.Scanner;


/** 
* 背包问题
* 
* 变形的背包的问题，这里加入了时间顺序
* 对应到背包问题上，就是多少体积内只准装哪个物体
* 传统的背包问题的递推公式为： dp[j] = max{dp[j], dp[j - v[i]] + w[i]]
* 然后的这里的递推公式也是这样，只不过，加上了前提条件
* 要判断该饭局是否能在这个时间段。j - nodes[i].duration <= nodes[i].lateStartTime（不能超过最迟开始时间）
* 
* 因为我们的思想仅仅是计算某个时间段的最大值，且我这里的内循环仅从该活动的结束时间往前算的
* 所以最后dp[maxTime]并不能记录最大，所以我用了一个全局max来记录最大
* @author special
* @date 2018年1月22日 上午9:22:23
*/
public class Pro137Improve1 { 
	
	static class Node{
    	int price;
    	int duration;
    	int end;
    	int lateStartTime;
    	
    	public Node(int price, int duration, int end, int lateStartTime){
    		this.price = price;
    		this.duration = duration;
    		this.end = end;
    		this.lateStartTime = lateStartTime;
    	}
    }
    public static void insertSort(Node[] nodes){
    	for(int i = 1; i < nodes.length; i++){
    		for(int j = i; j > 0 && nodes[j].end < nodes[j - 1].end; j--){
    			Node temp = nodes[j];
    			nodes[j] = nodes[j - 1];
    			nodes[j - 1] = temp;
    		}
    	}
    }
	public static int getMaxPrice(Node[] nodes, int maxTime){
		int max = Integer.MIN_VALUE;
		int[] dp = new int[maxTime + 1];
		for(int i = 0; i < nodes.length; i++){
			for(int j = nodes[i].end; j >= nodes[i].duration; j--){ //从该活动的结束时间往前算
				if(j - nodes[i].duration <= nodes[i].lateStartTime){
					dp[j] = Math.max(dp[j], dp[j - nodes[i].duration] + nodes[i].price);
					max = Math.max(max,dp[j]);
				}
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == -1) break;
			Node[] nodes = new Node[n];
			int price, duration, end, maxTime = Integer.MIN_VALUE;
			
			for(int i = 0; i < n; i++){
				price = input.nextInt();
				duration = input.nextInt();
				end = input.nextInt();
				nodes[i] = new Node(price, duration, end, end - duration);
				maxTime = Math.max(maxTime, end);
			}
			insertSort(nodes);
			System.out.println(getMaxPrice(nodes, maxTime));
		}
	}
}
