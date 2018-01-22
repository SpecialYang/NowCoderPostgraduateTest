package com.speical.first;

import java.util.Scanner;

/** 
* 大数加法（仅适用于全是正整数）
* 
* @author special
* @date 2018年1月1日 下午11:01:44
*/
public class Pro79 {
	
	/**
	 * 大数加法
	 * @param str1 
	 * @param str2
	 * @return 相加结果
	 */
	public static String add(String str1, String str2){
		while(str1.length() < str2.length()){
			str1 = "0" + str1;
		}
		while(str2.length() < str1.length()){
			str2 = "0" + str2;
		}
		char[] result = new char[str1.length() + 1];
		int carry = 0, temp;
		int index = result.length;
		for(int i = str1.length() - 1; i >= 0; i--){
			temp = str1.charAt(i) - '0' + str2.charAt(i) - '0' + carry;
			carry = temp / 10;
			temp %= 10;
			result[--index] = (char) (temp + '0');
		}
		if(carry > 0) result[--index] = (char) (carry + '0');
		return new String(result,index,result.length - index);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String sum = "0";
		while(input.hasNext()){
			String str = input.nextLine();
			if(str.equals("0")){
				System.out.println(sum);
				break;
			}else{
				sum = add(sum, str);
			}
		}
	}

}
