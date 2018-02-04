package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年2月4日 上午9:34:52
*/
public class Pro183 {
	
	/*
	 * 判断两个字符是否相等
	 */
	public static boolean isSame(char ch1, char ch2){
		if(ch1 >= 'A' && ch1 <= 'Z'){
			ch1 += 32;
		}
		if(ch2 >= 'A' && ch2 <= 'Z'){
			ch2 += 32;
		}
		return ch1 == ch2;
	}
	
	public static boolean isMatch(String pattern, String map){
		boolean flag = true;
		int index = 0, i = 0;
		for(; i < map.length() && index < pattern.length(); index++, i++){
			if(pattern.charAt(index) != '['){ //非中括号的情况
				if(!isSame(pattern.charAt(index), map.charAt(i))){
					flag = false;
					break;
				}
			}else if(pattern.charAt(index) == '['){  //中括号的情况
				while(pattern.charAt(++index) != ']' && !isSame(pattern.charAt(index), map.charAt(i)));
				if(pattern.charAt(index) == ']'){  
					flag = false;
					break;
				}else{
					while(pattern.charAt(++index) != ']');
				}
			}
		}
		if(index != pattern.length() || i != map.length()) flag = false;
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			input.nextLine();
			String[] maps = new String[n];
			for(int i = 0; i < n; i++){
				maps[i] = input.nextLine();
			}
			String pattern = input.nextLine();
			for(int i = 0; i < n; i++){
				if(isMatch(pattern, maps[i])){
					System.out.println((i + 1) + " " + maps[i]);
				}
			}
		}
	}

}
