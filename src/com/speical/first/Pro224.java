package com.speical.first;

import java.util.Scanner;

/**
 * 判断回文串
 * 
 * 用2个索引一个从头开始递增，一个从尾开始递减比较保守
 * @author Special
 * @time 2018/02/11 21:22:40
 */
public class Pro224 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String str = input.nextLine();
			boolean flag = true;
			for(int i = 0, j = str.length() - 1; i < j; i++, j--) {
				if(str.charAt(i) != str.charAt(j)) {
					flag = false;
					break;
				}
			}
			System.out.println(flag ? "Yes!" : "No!");
		}
	}

}
