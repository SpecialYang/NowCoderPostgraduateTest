package com.speical.first;

import java.util.Scanner;

/** 
* 根据今天星期几
* 判断出给定的日期是星期几
* 
* 我的思路好麻烦啊
* 分3种情况做的
* @author special
* @date 2018年1月4日 下午4:15:05
*/
public class Pro106 {
	static String[] months = {"","January", "February", "March", "April", "May", "June", "July", 
			"August", "September", "October", "November", "December"};
	static String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	
	static int[] days = {0,0,31,59,90,120,151,181,
						212,243,273,304,334,365};
	
	static int today = 4, todayYear = 2018;
	static String todayMonth = "January";
	
	public static boolean isLeapYear(int year){
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	
	public static int indexOf(String month){
		for(int i = 1; i <= 12; i++){
			if(months[i].equals(month)){
				return i;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int day = input.nextInt();
			String month = input.next();
			int year = input.nextInt();
			int totalDays = 0;
			int index1 = indexOf(month);
			int index2 = indexOf(todayMonth);
			if(year < todayYear){
				totalDays = (days[13] + (isLeapYear(year) && index1 <= 2 ? 1 : 0)) - days[index1] - day;
				for(int i = year + 1; i < todayYear; i++){
					totalDays += isLeapYear(i) ? 366 : 365;
				}
				index2 = indexOf(todayMonth);
				totalDays += days[index2] + (isLeapYear(todayYear) && index2 > 2 ? 1 : 0) + today; 
				System.out.println(week[(-totalDays % 7 + 7 + 4) % 7]);
			}else if(year == todayYear){
				totalDays = Math.abs((days[index1] + (isLeapYear(year) && index1 > 2 ? 1 : 0) + day)
						- (days[index2] + (isLeapYear(todayYear) && index2 > 2 ? 1 : 0) + today));
				System.out.println(week[(totalDays % 7 + 4) % 7]);
			}else{
				totalDays = (days[13] + (isLeapYear(todayYear) && index2 <= 2 ? 1 : 0)) - days[index2] - today;
				for(int i = todayYear + 1; i < year; i++){
					totalDays += isLeapYear(i) ? 366 : 365;
				}
				totalDays += days[index1] + (isLeapYear(year) && index1 > 2 ? 1 : 0) + day; 
				System.out.println(week[(totalDays % 7 + 4) % 7]);
			}
		}
	}

}
