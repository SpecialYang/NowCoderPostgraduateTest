package com.speical.first;

import java.util.Scanner;

/** 
* 字符串的反码
* @author special
* @date 2018年2月1日 上午10:35:41
*/
public class Pro169 {
	
	public static char complement(char ch){
		if(ch >= 'a' && ch <= 'z'){
			return (char) ('z' - (ch - 'a'));
		}else if(ch >= 'A' && ch <= 'Z'){
			return (char) ('Z' - (ch - 'A'));
		}else {
			return ch;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			if(str.equals("!")) break;
			for(int i = 0; i < str.length(); i++){
				System.out.print(complement(str.charAt(i)));
			}
			System.out.println();
		}
	}

}
