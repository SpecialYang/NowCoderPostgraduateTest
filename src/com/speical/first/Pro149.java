package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 最短路径问题
* 
* 此题为变形的最短路径，其实也很简单
* 原先选取点和更新距离只考虑距离，只要再加上权重就可以了
* 
* 然后注意更新距离时(distances[start] + dis[start][i] < distances[i]
* 可能因为dis的为int型最大值，加上distance会造成溢出，所以要先判断2点是否相连
* @author special
* @date 2018年1月26日 上午10:46:40
*/
public class Pro149 {
	static int[][] dis, weights;
	static boolean[] flag;
	static final int MAX = Integer.MAX_VALUE;
	
	public static void solution(int src, int drc, int n){
		int[] distances = new int[n];
		int[] prices = new int[n];
		Arrays.fill(distances, MAX);
		Arrays.fill(prices, MAX);
		for(int i = 0; i < n; i++){
			distances[i] = dis[src][i];
			prices[i] = weights[src][i];
		}
		flag[src] = true;
		int count = n - 1, start, minDis = MAX, minPrice = MAX;
		while(count-- > 0){
			start = -1;
			minDis = MAX;
			minPrice = MAX;
			for(int i = 0; i < n; i++){
				if(!flag[i] && (distances[i] < minDis 
							|| distances[i] == minDis && prices[i] < minPrice)){
					start = i;
					minDis = distances[i];
					minPrice = prices[i];
				}
			}
			if(start == drc) break;
			flag[start] = true;
			for(int i = 0; i < n; i++){	
				if(!flag[i] && dis[start][i] != MAX 
							&& (distances[start] + dis[start][i] < distances[i]
							|| distances[start] + dis[start][i] == distances[i]
						    && prices[start] + weights[start][i] < prices[i])){
					distances[i] = distances[start] + dis[start][i];
					prices[i] = prices[start] + weights[start][i];
				}
			}
		}
		System.out.println(minDis + " " + minPrice);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			if(n == 0 && m == 0) break;
			dis = new int[n][n];
			weights = new int[n][n];
			flag = new boolean[n];
			
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					dis[i][j] = i == j ? 0 : MAX;
					weights[i][j] = i == j ? 0 : MAX;
				}
			}
			int src, drc, distance, weight;
			while(m-- > 0){
				src = input.nextInt() - 1;
				drc = input.nextInt() - 1;
				distance = input.nextInt();
				weight = input.nextInt();
				if(distance <= dis[src][drc]){
					if(distance == dis[src][drc]){
						weights[src][drc] = weight < weights[src][drc] 
								  ? weight : weights[src][drc];
					}else{
						weights[src][drc] = weight;
					}
					weights[drc][src] = weights[src][drc];
					dis[src][drc] = distance;
					dis[drc][src] = dis[src][drc];
				}
			}
			src = input.nextInt() - 1;
			drc = input.nextInt() - 1;
			solution(src, drc, n);
		}
	}

}
