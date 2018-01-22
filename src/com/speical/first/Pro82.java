package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月2日 上午10:49:14
*/
public class Pro82 {
	static final int SIZE = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int a = input.nextInt();
			int sum = 0, num;
			for(int i = 0; i < SIZE; i++){
				num = input.nextInt();
				sum += num < a ? num : 0;
			}
			System.out.println(sum);
		}
	}

}
