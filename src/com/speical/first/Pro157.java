package com.speical.first;

import java.util.Scanner;

/** 
* 寻找权重最小的众数
* @author special
* @date 2018年1月30日 上午10:40:17
*/
public class Pro157 {
	static final int SIZE = 20;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int[] map = new int[11];
			for(int i = 0; i < SIZE; i++){
				map[input.nextInt()]++;
			}
			int max = 1;
			for(int i = 1; i < 11; i++){
				if(map[i] > map[max]){
					max = i;
				}
			}
			System.out.println(max);
		}
	}

}
