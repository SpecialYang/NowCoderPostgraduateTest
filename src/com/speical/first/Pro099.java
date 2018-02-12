package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 大数加，减，乘法
* 
* 很经典
* @author special
* @date 2018年1月3日 下午3:36:18
*/
public class Pro099 {
	
	public static String add(String num1, String num2){
		StringBuilder sb = new StringBuilder();
		int less = Math.abs(num1.length() - num2.length());
		while(less-- > 0){
			sb.append("0");
		}
		if(num1.length() < num2.length()){
			num1 = sb + num1;
		}else{
			num2 = sb + num2;
		}
		char[] result = new char[num1.length() + 1];
		int temp, carry = 0, index = result.length;
		for(int i = num1.length() - 1; i >= 0; i--){
			temp = num1.charAt(i) - '0' + num2.charAt(i) - '0' + carry;
			carry = temp / 10;
			temp %= 10;
			result[--index] = (char)(temp + '0');
		}
		if(carry > 0) result[--index] = (char)(carry + '0');
		return new String(result, index, result.length - index);
	}
	
	public static String subtract(String num1, String num2){
		StringBuilder sb = new StringBuilder();
		int less = Math.abs(num1.length() - num2.length());
		while(less-- > 0){
			sb.append("0");
		}
		boolean positive = true;  //很关键
		if(num1.length() < num2.length() ||
				(num1.length() == num2.length() && num1.compareTo(num2) < 0)){
			num1 = sb + num1;
			positive = false;
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}else{
			num2 = sb + num2;
		}
		char[] result = new char[num1.length() + 1];
		int temp, borrow = 0, index = result.length;
		for(int i = num1.length() - 1; i >= 0; i--){
			temp = num1.charAt(i) - num2.charAt(i) - borrow;
			if(temp < 0){
				temp += 10;
				borrow = 1;
			}else{
				borrow = 0;
			}
			result[--index] = (char)(temp + '0');
		}
		for(; index < result.length - 1 && result[index] == '0'; index++); //去掉前向0（0除外）
		if(!positive) result[--index] = '-'; //结果如果为负，添加一个负号
		return new String(result, index, result.length - index);
	}
	
	public static String mutiple(String num1, String num2){
		char[] result = new char[num1.length() + num2.length()]; //两数相乘的最大位数
		Arrays.fill(result, '0');
		int carry, temp;
		for(int j = num2.length() - 1; j >= 0; j--){
			carry = 0;
			for(int i = num1.length() - 1; i >= 0; i--){
				temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') 
					 + (result[i + j + 1] - '0') + carry;
				carry = temp / 10;
				temp %= 10;
				result[i + j + 1] = (char)(temp + '0'); //第j轮乘以第i位对应的位置为i + j + 1
			}
			if(carry > 0) result[j] = (char)(carry + '0'); // 第j轮对应的进位的位置为 j
		}
		int index = result[0] != '0' ? 0 : 1;  //看是否进位了
		return new String(result, index, result.length - index);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String num1 = input.nextLine();
			String num2 = input.nextLine();
			System.out.println(add(num1, num2));
			System.out.println(subtract(num1, num2));
			System.out.println(mutiple(num1, num2));
		}
	}

}
