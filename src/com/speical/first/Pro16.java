package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月21日 下午11:33:24
*/
public class Pro16 {
	public static long getFactorial(int n){
		long result = 1;
		for(int i = 2; i <= n; i++)
			result *= i;
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.println(getFactorial(n));
		}
	}

}
