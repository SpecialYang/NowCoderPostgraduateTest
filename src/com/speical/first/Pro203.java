package com.speical.first;

import java.util.Scanner;
/**
 * ip合理检测
 * 
 * 1.范围正确
 * 2.不能有数字和'.'以外的字符
 * 3.段数为4
 * @author Special
 * @time 2018/02/08 16:08:05
 */
public class Pro203 {
	
	private static boolean isNum(char ch) {
		return ch >= '0' && ch <= '9';
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String str = input.next();
			int num = 0, count = 0;
			boolean flag = true;
			for(int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if(isNum(ch)) {
					num = 0;
					while(i < str.length() && isNum(str.charAt(i))) {
						num = num * 10 + str.charAt(i++) - '0';
					}
					if(i < str.length() && str.charAt(i) != '.' 
							||num < 0 || num >= 256) {
						flag = false;
						break;
					}
					count++;
				}else if(ch != '.') {
					flag = false;
					break;
				}
			}
			if(count < 4) { flag = false; }
			System.out.println(flag ? "Yes!" : "No!");
		}
	}

}
