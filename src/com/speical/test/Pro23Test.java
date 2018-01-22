package com.speical.test;



import java.util.Scanner;

import org.junit.Test;

import com.speical.first.Pro23;

/** 
*
* @author special
* @date 2017年12月23日 下午4:05:14
*/
public class Pro23Test {

	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			System.out.println(Pro23.mutiple(str1, str2));
		}
	}
}
