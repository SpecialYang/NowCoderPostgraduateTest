package com.speical.first;

import java.util.Scanner;

/**
 * 带逗号的数字相加
 * 
 * 数字在int的范围内，所以大数相加都不用
 * @author Special
 * @time 2018/02/10 17:36:04
 */
public class Pro218 {
	
	public static int convertToInt(String nums) {
		boolean isPostive = nums.charAt(0) != '-' ? true : false;
		int result = 0;
		for(int i = 0; i < nums.length(); i++) {
			//我想多了，根本不用按部分处理，直接判断是逗号话就跳过，否则乘10加数字就行了
//			num = 0;
//			while(i < nums.length() && nums.charAt(i) >= '0' && nums.charAt(i) <= '9') {
//				num = num * 10 + nums.charAt(i++) - '0';
//			}
//			result = result * 1000 + num;
			if(nums.charAt(i) >= '0' && nums.charAt(i) <= '9') {
				result = result * 10 + nums.charAt(i) - '0';
			}
		}
		return isPostive ? result : -result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String num1 = input.next();
			String num2 = input.next();
			System.out.println(convertToInt(num1) + convertToInt(num2));
		}
	}

}
