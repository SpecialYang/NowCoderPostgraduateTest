package com.speical.first;

import java.util.Scanner;

public class Pro190 {
	
	public static boolean compare(String strA, String strB) {
		boolean flag = false;
		int index = 0;
		for(; index < strA.length(); index++) {
			if(strA.charAt(index) > strB.charAt(0)) {
				break;
			}
		}
		int count;
		if(index < strA.length()) {
			switch (strB.length()) {
			case 1: flag = true; break;
			case 2:
				for(int j = index; j < strA.length();) {
					if((++j) < strA.length() && strA.charAt(j) == strA.charAt(j - 1)) {
						flag = true;
						break;
					}
				}
				break;
			case 3:
				for(int j = index; j < strA.length();) {
					count = 2;
					while((++j) < strA.length() && strA.charAt(j) == strA.charAt(j - 1)) {
						count--;
					}
					if(count == 0) {
						flag = true;
						break;
					}
				}
				break;
			case 4:
				for(int j = index; j < strA.length();) {
					count = 3;
					while((++j) < strA.length() && strA.charAt(j) == strA.charAt(j - 1)) {
						count--;
					}
					if(count == 0) {
						flag = true;
						break;
					}
				}
				break;
			case 5:
				char ch;
				for(int j = index; j < strA.length(); j++) {
					count = 4;
					ch = strA.charAt(j);
					while(strA.indexOf((char)(++ch)) != -1 && count-- > 0);
					if(count == 0) {
						flag = true;
						break;
					}
				}
				break;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String strA = input.nextLine();
			String strB = input.nextLine();
			System.out.println(compare(strA, strB) ? "YES" : "NO");
		}
	}

}
