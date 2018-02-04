package com.speical.first;

import java.util.Scanner;

/** 
* 开门人与关门人
* 
* 一次遍历即可，记录最小值和最大值即可
* 
* 注意对于每次的输入的时间的字符串要转换成int型，方便比较大小
* @author special
* @date 2018年1月23日 下午10:13:50
*/
public class Pro138 {
	
	public static int convertSeconds(String time){
		int seconds = 0, temp, count;
		for(int i = 0; i < time.length(); i++){
			temp = 0;
			count = 2;
			while(count-- > 0){
				temp = temp * 10 + (time.charAt(i++) - '0');
			}
			seconds = seconds * 60 + temp;
		}
		return seconds;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			String openSno = "", closeSno = "", sno;
			int openTime = Integer.MAX_VALUE, closeTime = Integer.MIN_VALUE, enterTime, exitTime;
			while(n-- > 0){
				sno = input.next();
				enterTime = convertSeconds(input.next());
				exitTime = convertSeconds(input.next());
				if(enterTime < openTime){
					openTime = enterTime;
					openSno = sno;
				}
				if(exitTime > closeTime){
					closeTime = exitTime;
					closeSno = sno;
				}
			}
			System.out.println(openSno + " " + closeSno);
		}
	}

}
