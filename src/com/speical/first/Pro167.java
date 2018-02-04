package com.speical.first;

import java.util.Scanner;

/** 
* 字符串去特定的字符
* @author special
* @date 2018年2月1日 上午10:06:49
*/
public class Pro167 {

	public static String delete(String str, char delete){
		char[] result = new char[str.length()];
		int index = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) != delete){
				result[index++] = str.charAt(i);
			}
		}
		return new String(result, 0, index);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			char delete = input.nextLine().charAt(0);
			System.out.println(delete(str, delete));
		}
	}

}
