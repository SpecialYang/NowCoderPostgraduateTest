package com.speical.first;

import java.util.Scanner;

/** 
* 经典dfs
* 
* 添加一个status记录上一次的状态即可
* 每次要记录本次的代价，然后更新该点的状态
* 同时记得累加代价即可
* @author special
* @date 2018年1月3日 上午11:35:12
*/
public class Pro096 {
	static final int SIZE = 6, MOD = 4;
	static int startX, startY, endX, endY, minCost;
	static int[][] values, steps = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][] flag;
	
	public static boolean isValid(int x, int y){
		return !(x < 0 || x >= SIZE || y < 0 || y >= SIZE);
	}
	
	public static void dfs(int x, int y, int status, int cost){
		if(cost >= minCost) return;
		if(x == endX && y == endY){
			minCost = Math.min(minCost, cost);
			return;
		}
		int tempStatus, tempCost;
		for(int i = 0; i < 4; i++){
			int tempX = x + steps[i][0];
			int tempY = y + steps[i][1];
			if(isValid(tempX,tempY) && !flag[tempX][tempY]){
				flag[tempX][tempY] = true;
				tempCost = values[tempX][tempY] * status; //本次代价
				tempStatus = tempCost % MOD + 1;          //本次状态
				tempCost += cost;                         //累加代价
				dfs(tempX, tempY, tempStatus, tempCost);
				flag[tempX][tempY] = false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				values = new int[SIZE][SIZE];
				flag = new boolean[SIZE][SIZE];
				minCost = Integer.MAX_VALUE;
				for(int i = 0; i < SIZE; i++){
					for(int j = 0; j < SIZE; j++){
						values[i][j] = input.nextInt();
					}
				}
				startX = input.nextInt();
				startY = input.nextInt();
				endX = input.nextInt();
				endY = input.nextInt();
				flag[startX][startY] = true;
				dfs(startX, startY, 1, 0);
				System.out.println(minCost);
			}
		}
	}

}
