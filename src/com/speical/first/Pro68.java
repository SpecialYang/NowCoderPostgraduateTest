package com.speical.first;

import java.util.Scanner;

/** 
* 统计加法进位次数
* 
* 直接大数思想就行
* 就是不用保留计算结果了，注意不一样长时，通过前补0凑齐
* @author special
* @date 2017年12月31日 上午10:30:57
*/
public class Pro68 {
	
	public static int getTimes(String str1, String str2){
		while(str1.length() < str2.length()){
			str1 = "0" + str1;
		}
		while(str2.length() < str1.length()){
			str2 = "0" + str2;
		}
		int carry = 0;
		int times = 0;
		for(int i = str1.length() - 1; i >= 0; i--){
			int temp = str1.charAt(i) - '0' + str2.charAt(i) - '0' + carry;
			if(temp > 9){
				times++;
				carry = 1;
			}else{
				carry = 0;
			}
		}
		return times;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.next();
			String str2 = input.next();
			if(str1.equals("0") && str2.equals("0")) break;
			int times = getTimes(str1,str2);
			System.out.println((times == 0 ? "NO" : times) 
					+ " carry operation" + (times <= 1 ? "." : "s."));
		}
	}

}
