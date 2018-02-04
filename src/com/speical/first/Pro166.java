package com.speical.first;

import java.util.Scanner;

/** 
* 求最大值
* @author special
* @date 2018年1月31日 下午5:03:44
*/
public class Pro166 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < 10; i++){
				max = Math.max(max, input.nextInt());
			}
			System.out.println("max=" + max);
		}
	}

}
