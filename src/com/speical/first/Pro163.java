package com.speical.first;

import java.util.Scanner;

/** 
* 字符串倒置
* @author special
* @date 2018年1月31日 下午12:07:35
*/
public class Pro163 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			char[] array = str.toCharArray();
			for(int i = 0; i < array.length / 2; i++){
				char temp = array[i];
				array[i] = array[array.length - 1 - i];
				array[array.length - 1 - i] = temp;
			}
			System.out.println(new String(array));
		}
	}

}
