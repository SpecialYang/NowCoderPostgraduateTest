package com.speical.first;

import java.util.Scanner;
/**
 * N阶台阶问题
 * 
 * kinds[i] = kinds[i - 1] + kinds[i - 2]
 * 意思就是走到i台阶步数等于走到i-1的步数加上走到i-2的步数
 * 因为走到i台阶只能由这两种台阶情况构成
 * @author Special
 * @time 2018/02/11 20:06:54
 */
public class Pro222 {
	
	static int SIZE = 90 + 5;
	static int[] kinds = new int[SIZE];
	
	public static void init() {
		kinds[0] = kinds[1] = 1;
		for(int i = 2; i < SIZE; i++) {
			kinds[i] = kinds[i - 2] + kinds[i - 1];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			System.out.println(kinds[input.nextInt()]);
		}
	}

}
