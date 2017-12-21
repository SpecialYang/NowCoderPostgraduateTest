package com.speical.first;

import java.util.Scanner;

/** 
* 字符串反序
* @author special
* @date 2017年12月19日 下午1:53:06
*/
public class Pro04 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			for(int i = str.length() - 1; i >= 0; i--)
				System.out.print(str.charAt(i));
			System.out.println();
		}
	}
}
