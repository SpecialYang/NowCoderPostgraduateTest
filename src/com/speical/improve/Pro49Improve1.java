package com.speical.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月28日 下午2:55:25
*/
public class Pro49Improve1 {
	static final int SIZE = 100 + 5;
	static int[] sum = new int[SIZE];
	private static int isRelativeSeven(int n){
		return n % 7 == 0 || n % 10 == 7 || n / 10 == 7 ? 0 : n * n;
	}
	public static void init(){
		for(int i = 1; i < SIZE; i++){
			sum[i] = sum[i - 1] + isRelativeSeven(i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			System.out.println(sum[input.nextInt()]);
		}
	}
}
