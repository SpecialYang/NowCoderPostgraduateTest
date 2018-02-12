package com.speical.improve;

import java.util.Scanner;

/**
 * 打印日期
 * 
 * 不累加的好可以一次性根据是否是闰年把握好天数
 * 
 * 而且利用format可以很容易输出所要的格式
 * @author Special
 * @time 2018/02/12 22:30:13
 */
public class Pro219Improve1 {
	
	static int[] months = {0, 31, 28, 31, 30, 31, 30, 
							31, 31, 30, 31, 30, 31};
	
	public static boolean isLoopYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int year = input.nextInt();
			int days = input.nextInt();
			months[2] = isLoopYear(year) ? 29 : 28;
			for(int i = 1; i <= 12; i++) {
				if(days <= months[i]) {
					System.out.format("%d-%02d-%02d\n", year, i, days);
					break;
				}else {
					days -= months[i];
				}
			}
		}
	}
}
