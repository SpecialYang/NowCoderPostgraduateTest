package com.speical.first;

import java.util.Scanner;

/** 
* 完数
* 
* 完数 = 该数的因子之和
* 
* @author special
* @date 2018年1月30日 上午11:02:02
*/
public class Pro159 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt(), sum = 0;
			boolean flag = false;
			for(int i = 2; i <= n; i++){ // 1不是完数
				sum = 1; // 任何一个大于1的因子必然有1
				for(int j = 2; j <= Math.sqrt(i); j++){
					if(i % j == 0){
						sum += j;
						if(i / j != j){
							sum += i / j;
						}
					}
				}
				if(sum == i){
					System.out.print((flag ? " " : "") + i);
					flag = true;
				}
			}
			System.out.println();
		}
	}

}
