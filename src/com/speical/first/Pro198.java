package com.speical.first;

import java.util.Scanner;

/**
 * 字符串合并
 * @author Special
 * @time 2018/02/08 11:01:20
 */
public class Pro198 {
	
	public static String getMerge(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		int index1 = 0, index2 = str1.length() - 1;
		for(int i = 0; i < str1.length() * 2; i++) {
			if((i & 1) == 0) {
				sb.append(str1.charAt(index1++));
			}else {
				sb.append(str2.charAt(index2--));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			System.out.println(getMerge(str1, str2));
		}
	}

}
