package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月31日 上午10:46:40
*/
public class Pro69 {
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			double result = 0;
			for(int i = 0; i < n; i++){
				result += input.nextInt();
			}
			System.out.format("%.2f\n", result / n);
		}
	}
}
