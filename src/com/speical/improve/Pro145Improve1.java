package com.speical.improve;

import java.util.Arrays;
import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月25日 上午11:11:10
*/
public class Pro145Improve1 {
	static int[][] dis;
	static boolean[] flag;
	static final int MAX = Integer.MAX_VALUE;
	
	public static int getMinDis(int n){
		int[] cost = new int[n];
		Arrays.fill(cost, MAX);
		for(int i = 1; i < n; i++){
			cost[i] = dis[0][i];
		}
 		flag[0] = true;
		int count = n - 1, result = 0, start, min;
		while(count-- > 0){
			start = -1;
			min = MAX;
			for(int j = 1; j < n; j++){
				if(!flag[j] && cost[j] < min){
					start = j;
					min = cost[j];
				}
			}
			flag[start] = true;
			result += min;
			for(int j = 1; j < n; j++){  //记录中间状态，类似动态规划的思想
				if(!flag[j] && dis[start][j] < cost[j]){
					cost[j] = dis[start][j];
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			dis = new int[n][n];
			flag = new boolean[n];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					dis[i][j] = i == j ? 0 : MAX;
				}
			}
			int src, drc, distance;
			for(int i = 0; i < n * (n - 1) / 2; i++){
				src = input.nextInt() - 1;
				drc = input.nextInt() - 1;
				distance = input.nextInt();
				dis[src][drc] = distance < dis[src][drc] ? distance : dis[src][drc];
				dis[drc][src] = dis[src][drc];
			}
			System.out.println(getMinDis(n));
		}
	}
}
