package com.speical.first;

import java.util.Scanner;

/** 
* 是否与7有关
* 
* 其实这里是百位数，可以直接暴力列举
* @author special
* @date 2017年12月28日 下午2:47:50
*/
public class Pro49 {
	static final int SIZE = 100 + 5;
	static int[] sum = new int[SIZE];
	private static int isRelativeSeven(int n){
		return n % 7 == 0 || String.valueOf(n).contains("7") ? 0 : n * n;
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
