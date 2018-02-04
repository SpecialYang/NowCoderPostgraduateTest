package com.speical.first;

import java.util.Scanner;
/** 
* 百万富翁
* @author special
* @date 2018年1月31日 上午9:55:47
*/
public class Pro162 {
	
	/**
	 * 快速幂
	 * @param num 底数
	 * @param n   指数
	 * @return
	 */
	public static int fastPower(int num, int n){
		int result = 1;
		int digit = num;
		while(n != 0){
			if((n & 1) == 1){  //该数位为1， 意思分解为幂相乘时，有该数
				result *= digit; 
			}
			n >>= 1;
			digit *= digit; //指数每右移一位，指数相当于乘以2，对应到幂结果应执行一次平方
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int millionare = 10 * 30;
		int stranger = fastPower(2, 30) - 1;
		System.out.println(millionare + " " + stranger);
		//System.out.println(300 + " " + 1073741823);
	}

}
