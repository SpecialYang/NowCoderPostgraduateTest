package com.speical.improve;

import java.util.Scanner;

/** 
* 统计进位次数
* @author special
* @date 2017年12月31日 下午1:44:48
*/
public class Pro68Improve1 {
	public static int getTimes(int num1, int num2){
		int times = 0;
		int carry = 0;
		while(num1 != 0 || num2 != 0){  //因为还可以一直向前进位，所以要使用或
			carry = (num1 % 10 + num2 % 10 + carry) / 10;
			if(carry == 1){
				times++;
			}
			num1 /= 10;
			num2 /= 10;
		}
		return times;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num1 = input.nextInt();
			int num2 = input.nextInt();
			if(num1 == 0 && num2 == 0) break;
			int times = getTimes(num1,num2);
			System.out.println((times == 0 ? "NO" : times) 
					+ " carry operation" + (times <= 1 ? "." : "s."));
		}
	}

}
