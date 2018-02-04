package com.speical.first;

import java.util.Scanner;

/** 
* 二进制数
* 
* jdk的默认实现方法
* @author special
* @date 2018年2月4日 上午10:38:54
*/
public class Pro184 {
	public static String toBinary(int num){
		char[] digits = new char[32];
		int index = 32;
		while(num != 0){
			digits[--index] = (char) ('0' + (num & 1));
			num >>>= 1;
		}
		return new String(digits, index, 32 - index);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.println(toBinary(n));
		}
	}

}
