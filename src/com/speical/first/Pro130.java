package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月7日 上午11:41:59
*/
public class Pro130 {
	public static int getSteps(int num){
		int steps = 0;
		while(num != 1){
			if((num & 1) == 1){
				num = (num * 3 + 1) >> 1;
			}else{
				num >>= 1;
			}
			steps++;
		}
		return steps;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			System.out.println(getSteps(n));
		}
	}

}
