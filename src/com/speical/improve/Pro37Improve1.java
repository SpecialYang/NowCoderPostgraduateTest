package com.speical.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月26日 下午9:13:47
*/
public class Pro37Improve1 {
	public static boolean isAllSame(int[] candies){
		for(int i = 0; i < candies.length - 1; i++){
			if(candies[i] != candies[i + 1])
				return false;
		}
		return true;
	}
	
	public static void solution(int[] candies, int n){
		int times = 0;
		int temp1,temp2;
		while(!isAllSame(candies)){
			times++;
			temp1 = candies[n - 1];
			for(int i = 0; i < n; i++){
				temp2 = candies[i];
				candies[i] -= temp2 / 2;
				candies[i] += temp1 / 2;
				temp1 = temp2;
				candies[i] += (candies[i] & 1) == 1 ? 1 : 0;
			}
		}
		System.out.println(times + " " + candies[0]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			int[] candies = new int[n];
			for(int i = 0; i < n; i++){
				candies[i] = input.nextInt();
			}
			solution(candies,n);
		}
	}

}
