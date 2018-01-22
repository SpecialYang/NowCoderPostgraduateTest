package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月5日 上午9:50:27
*/
public class Pro111 {
	public static boolean isUpperLetter(char ch){
		return ch >= 'A' && ch <= 'Z';
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int[] map = new int[26];
			char item;
			for(int i = 0; i < str.length(); i++){
				item = str.charAt(i);
				if(isUpperLetter(item)){
					map[item - 'A']++;
				}
			}
			for(int i = 0; i < 26; i++){
				System.out.println((char)(i + 'A') + ":" + map[i]);
			}
		}
	}

}
