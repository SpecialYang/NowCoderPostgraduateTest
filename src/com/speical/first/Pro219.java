package com.speical.first;

import java.util.Scanner;

/**
 * 给定年份和天数
 * 
 * 给出是当年那月那日
 * 
 * 注意闰年，提前累加好天数简单点
 * 放假了，学校暖气不给力了啊，手好冷,md
 * @author Special
 * @time 2018/02/10 17:46:57
 */
public class Pro219 {
	
	static int[] months = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
	
	public static boolean isLoopYear(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int year = input.nextInt();
			int days = input.nextInt();
			boolean isLoop = isLoopYear(year);
			int month = 1;
			for(month = 1; month < 13; month++) {
				if(days <= months[month] + (isLoop && month >= 2 ? 1 : 0)) {
					break;
				}
			}
			int day = days - (months[month - 1] + (isLoop && month - 1 >= 2 ? 1 : 0));
			System.out.println(year + "-" + (month >= 10 ? "" : "0") + month + "-"
										  + (day >= 10 ? "" : "0") + day);
		}
	}

}
