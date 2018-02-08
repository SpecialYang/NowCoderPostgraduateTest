package com.speical.first;

import java.util.Scanner;

/**
 * @author Special
 * @time 2018/02/08 16:00:28
 */
public class Pro202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String str = input.nextLine();
			int count = 0;
			boolean flag = false;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) != ' ' && str.charAt(i) != '.') {
					count = 0;
					while(i < str.length() && str.charAt(i) != ' ' && str.charAt(i++) != '.') {
						count++;
					}
					System.out.print((!flag ? "" : " ") + count);
					flag = true;
				}
			}
		}
	}

}
