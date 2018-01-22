package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月25日 上午10:56:01
*/
public class Pro32 {
	static String lowerMap = "bcdefghigklmnopqrstuvwxyza";
	static String uppperMap = "BCDEFGHIGKLMNOPQRSTUVWXYZA";
	
	private static boolean isUpper(char ch) { return ch >= 'A' && ch <= 'Z'; }
	
	private static boolean isLower(char ch) { return ch >= 'a' && ch <= 'z'; }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			input.nextLine();
			while(n-- > 0){
				String password = input.nextLine();
				for(int i = 0; i < password.length(); i++){
					char letter = password.charAt(i);
					if(isUpper(letter)){
						System.out.print(uppperMap.charAt(letter - 'A'));
					}else if(isLower(letter)){
						System.out.print(lowerMap.charAt(letter - 'a'));
					}else {
						System.out.print(letter);
					}
				}
				System.out.println();
			}
		}
	}

}
