package com.speical.first;

import java.util.Scanner;

/** 
* 第几天，记录前缀，记录贡献
* 分模块，一目了然
* @author special
* @date 2017年12月22日 下午10:36:58
*/
public class Pro18 {
	private static final int[] days = {
			0,31,59,90,120,151,181,212,243,273,304,334,365};
	
	private static boolean isLeapYear(int year){
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	public static int getDays(int year, int month, int day){
		return days[month - 1] + day + (isLeapYear(year) && month > 2 ? 1 : 0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int year = input.nextInt();
			int month = input.nextInt();
			int day = input.nextInt();
			System.out.println(getDays(year,month,day));
		}
	}

}
