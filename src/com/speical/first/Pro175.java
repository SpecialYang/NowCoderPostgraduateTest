package com.speical.first;

import java.util.Scanner;

/** 
* 数位和
* @author special
* @date 2018年2月2日 上午11:01:37
*/
public class Pro175 {
	
	public static int sumDigits(int num){
		int sum = 0;
		while(num != 0){
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.print(sumDigits(n)+ " " + sumDigits(n * n));
		}
	}

}
