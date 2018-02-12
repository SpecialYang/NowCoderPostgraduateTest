package com.speical.first;

import java.util.Scanner;

/** 
* 整数的反转
* @author special
* @date 2018年1月3日 上午11:22:53
*/
public class Pro095 {
	
	public static int reverse(int num){
		int result = 0;
		while(num != 0){
			result = result * 10 + num % 10;
			num /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				int a = input.nextInt();
				int b = input.nextInt();
				System.out.println(reverse(a) + reverse(b) == reverse(a + b) ?
								   a + b : "NO");
			}
		}
	}

}
