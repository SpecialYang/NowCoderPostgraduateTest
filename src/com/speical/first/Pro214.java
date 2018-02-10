package com.speical.first;

import java.util.Scanner;
/**
 * 守型数
 * @author Special
 * @time 2018/02/10 15:02:35
 */
public class Pro214 {
	
	static final int SIZE = 105;
	static boolean[] isShouXing = new boolean[SIZE];
	
	/**
	 * 打表
	 */
	public static void init() {
		/**
		 * 用于取余，因为1到9的平方数对10取余即可
		 * 10到99则需要对100取余才能判断是否平方的地位是它本身
		 * 之后100 到 999 则需要对10000取余
		 * .....
		 * 类推出
		 * 只要当前的遍历的索引等于我们取余的数了，
		 * 说明我们数的本身多了一位，所以用于取余的数乘以10多出来一位
		 */
		int digit = 10;  
		for(int i = 0; i < SIZE; i++) {
			digit = i == digit ? digit * 10 : digit;
			if((i * i) % digit == i) {
				isShouXing[i] = true;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			System.out.println(isShouXing[input.nextInt()] ? "Yes!" : "No!");
		}
	}

}
