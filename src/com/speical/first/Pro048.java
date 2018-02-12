package com.speical.first;

import java.util.Scanner;

/** 
* 最小生成树
* 
* n的平方的实现方法
* 
* 坑爹题目：有不连通测试用例
* @author special
* @date 2017年12月28日 上午11:11:18
*/
public class Pro48 {
	static int[][] cost;
	static boolean[] flag;
	static final int MAX = Integer.MAX_VALUE;
	
	public static int getMinCost(){
		int result = 0;
		int start, min, n = flag.length;
		flag[0] = true;
		while(--n > 0){
			start = -1;
			min = MAX;
			for (int i = 0; i < flag.length; i++) {
				if (flag[i]) {
					for (int j = 0; j < flag.length; j++) {
						if (!flag[j] && cost[i][j] < min) {
							start = j;
							min = cost[i][j];
						}
					}
				}
			}
			if(min == MAX) break; //这个题好坑，给定的图竟然不是连通的
			flag[start] = true;
			result += min;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int lines = input.nextInt();
			if(lines == 0) break;
			cost = new int[lines][lines];
			flag = new boolean[lines];
			for(int i = 0; i < lines; i++){
				for(int j = 0; j < lines; j++){
					cost[i][j] = MAX;
				}
			}
			for(int i = 0; i < lines - 1; i++){
				int start = input.next().charAt(0) - 'A';
				int k = input.nextInt();
				while(k-- > 0){
					int end = input.next().charAt(0) - 'A';					
					int price = input.nextInt();
					if(price < cost[start][end]){
						cost[start][end] = price;
						cost[end][start] = price;
					}
				}
			}
			System.out.println(getMinCost());
		}
	}

}
