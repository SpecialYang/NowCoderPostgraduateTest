package com.speical.first;

import java.util.Scanner;

/** 
* 计算2个日期的差值
* 
* 计算2个日期都到两者最小年的1月1号的天数
* 然后计算差值就可以了
* @author special
* @date 2018年1月4日 下午7:29:45
*/
public class Pro109 {
	static int[] days = {0,0,31,59,90,120,151,181,
						 212,243,273,304,334,365};
	
	public static boolean isLeapYear(int year){
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	public static int[] parseDate(String dateStr){
		int[] result = new int[3];
		result[0] = Integer.parseInt(dateStr.substring(0,4));
		result[1] = Integer.parseInt(dateStr.substring(4,6));
		result[2] = Integer.parseInt(dateStr.substring(6,8));
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String dateStr1 = input.nextLine();
			String dateStr2 = input.nextLine();
			int[] date1 = parseDate(dateStr1);
			int[] date2 = parseDate(dateStr2);
			int year = Math.min(date1[0], date2[0]);
			int totalDays1 = days[date1[1]] + 
					(isLeapYear(date1[0]) && date1[1] > 2 ? 1 : 0) + date1[2];
			for(int i = date1[0] - 1; i >= year; i--){
				totalDays1 += isLeapYear(i) ? 366 : 365;
			}
			int totalDays2 = days[date2[1]] + 
					(isLeapYear(date2[0]) && date2[1] > 2 ? 1 : 0) + date2[2];
			for(int i = date2[0] - 1; i >= year; i--){
				totalDays2 += isLeapYear(i) ? 366 : 365;
			}
			System.out.println(Math.abs(totalDays1 - totalDays2) + 1); 
		}
	}

}
