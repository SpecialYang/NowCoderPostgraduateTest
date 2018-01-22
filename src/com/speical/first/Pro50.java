package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月28日 下午3:02:41
*/
public class Pro50 {
	public static int getNum(String str){
		int result = 0;
		int n = str.length();
		for(int i = 0; i < str.length(); i++,n--){
			result += (str.charAt(i) - '0') * ((1 << n) - 1);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			if(str.equals("0")) break;
			System.out.println(getNum(str));
		}
	}

}
