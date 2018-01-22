package com.speical.improve;

import java.util.Scanner;

/** 
* 通过移位简化做法
* 从高位或者低位都可以
* @author special
* @date 2017年12月27日 下午3:08:09
*/
public class Pro44Improve1 {
	
	public static int getSkewBinary(String str){
		int n = str.length();
		int result = 0;
		/**
		 * 低位开始
		 */
		/*
		for(int i = str.length() - 1; i >= 0; i--){
			if(str.charAt(i) != '0'){
				result += (str.charAt(i) - '0') * ((n << (str.length() - 1 - i)) - 1);
			}
		}*/
		/**
		 * 高位开始
		 */
		for(int i = 0; i < str.length(); i++,n--){
			if(str.charAt(i) != '0'){
				result += (str.charAt(i) - '0') * ((1 << n) - 1);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			System.out.println(getSkewBinary(str));
		}
	}

}
