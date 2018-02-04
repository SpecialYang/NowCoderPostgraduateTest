package com.speical.first;

import java.util.Scanner;

/** 
* 判断质数
* 
* 注意循环最大到数的平方根即可
* @author special
* @date 2018年1月30日 上午11:15:13
*/
public class Pro160 {
	
	public static boolean isPrime(int num){
		if(num <= 1) return false;
		for(int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.println(isPrime(n) ? "yes" : "no");
		}
	}

}
