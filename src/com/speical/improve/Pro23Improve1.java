package com.speical.improve;

import java.util.Scanner;

/** 
* 大数的阶乘
* @author special
* @date 2017年12月23日 下午4:36:47
*/
public class Pro23Improve1 {
	private static String[] factories = new String[1000 + 5];
	static{
		factories[0] = "1";
		factories[1] = "1";
	}
	/**
	 * 两字符串相乘
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String mutiple(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		int totalLength = length1 + length2;
		char[] result = new char[totalLength]; //两数相乘最大位数为 两数位数之和
		for(int i = 0; i < totalLength; i++) result[i] = '0'; //注意初始化为'0'
		int carry = 0;
		for(int j = length2 - 1; j >= 0; j--){
			carry = 0;
			for(int i = length1 - 1; i >= 0; i--){
				int temp = (str1.charAt(i) - '0') * (str2.charAt(j) - '0')
						+ (result[i + j + 1] - '0') + carry;
				if(temp >= 10){
					carry = temp / 10; //注意此处的顺序，坑死我了
					temp %= 10;
				}else {
					carry = 0;
				}
				result[i + j + 1] = (char) (temp + '0'); // i + j + 1正好第j轮相乘，个位应该放的位置
			}
			if(carry > 0) result[j] = (char) (carry + '0'); // j 正好是第j轮相乘的应该进位的位置
		}
		return new String(result).substring(result[0] != '0' ? 0 : 1);
	}
	
	public static String getFactories(int n){
		String res = "1";
		for(int i = n; i >= 2; i--){
			if(factories[i] != null){ 
				res = mutiple(res,factories[i]);
				break;
			}
			else
				res = mutiple(res, String.valueOf(i));
		}
		factories[n] = res;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.println(getFactories(n));
		}
	}
}
