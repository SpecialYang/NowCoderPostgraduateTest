package com.speical.first;

import java.math.BigInteger;
import java.util.Scanner;

/** 
* 大数的二进制表达
* 
* 然后二进制逆序并还原成十进制
* @author special
* @date 2017年12月23日 下午8:08:07
*/
public class Pro025 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String reverse = new StringBuilder(new BigInteger(str).toString(2)).reverse().toString();
			System.out.println(new BigInteger(reverse,2));
		}
	}

}
