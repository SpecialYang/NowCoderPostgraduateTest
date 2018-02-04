package com.speical.first;

import java.util.Scanner;

/** 
* 求最大公约数
* @author special
* @date 2018年1月30日 上午10:44:58
*/
public class Pro158 {
	
	public static int GCD(int a, int b){
		return a % b == 0 ? b : GCD(b, a % b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			System.out.println(GCD(input.nextInt(), input.nextInt()));
		}
	}

}
