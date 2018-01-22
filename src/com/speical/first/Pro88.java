package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月2日 下午2:30:12
*/
public class Pro88 {
	static String decode = "VWXYZABCDEFGHIJKLMNOPQRSTU";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String start = input.nextLine();
			if(start.equals("ENDOFINPUT")) break;
			String content = input.nextLine();
			input.nextLine();
			for(int i = 0; i < content.length(); i++){
				char ch = content.charAt(i);
				if(ch >= 'A' && ch <= 'Z'){
					System.out.print(decode.charAt(ch - 'A'));
				}else{
					System.out.print(ch);
				}
			}
			System.out.println();
		}
	}

}
