package com.speical.first;

import java.util.Scanner;

/**
 * 大数相加
 * 
 * 前向补零做法
 * @author Special
 * @time 2018/02/09 10:02:52
 */
public class Pro206 {
	
	public static String add(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int less = Math.abs(num1.length() - num2.length());
        while(less-- > 0) {
        	sb.append("0");	
        }
        if(num1.length() < num2.length()) {
        	num1 = sb.toString() + num1;
        }else {
        	num2 = sb.toString() + num2;
        }
        int length = Math.max(num1.length(), num2.length());
        char[] result = new char[length + 1];
        int index = result.length, temp, carry = 0;
        for(int i = length - 1; i >= 0; i--) {
        	temp = num1.charAt(i) - '0' + num2.charAt(i) - '0' + carry;
        	carry = temp / 10;
        	result[--index] = (char)(temp % 10 + '0');
        }
        if(carry > 0) { result[--index] = (char)(carry + '0'); }
        return new String(result, index, result.length - index);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String num1 = input.next();
			String num2 = input.next();
			System.out.println(add(num1, num2));
		}
	}

}
