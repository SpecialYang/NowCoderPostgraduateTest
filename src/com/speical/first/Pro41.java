package com.speical.first;

import java.util.Scanner;

/** 
* 其实这个题之前也有过啊，上一次是把大数从m进制转换为n进制
* 
* 只不过这个题特殊了，把10进制转换为2进制
* @author special
* @date 2017年12月27日 上午9:58:46
*/
public class Pro41 {
	public static int[] convertToInt(String str){
		int[] result = new int[str.length()];
		for(int i = 0;i < str.length(); i++){
			result[i] = str.charAt(i) - '0';
		}
		return result;
	}
	public static String getBinaryNum(int[] num){
		StringBuilder sb = new StringBuilder();
		int r;
		for(int i = 0; i < num.length;){
			r = 0;
			for(int j = 0; j < num.length; j++){
				num[j] += r * 10;
				r = num[j] % 2;
				num[j] /= 2;
			}
			sb.append(r);
			if(num[i] == 0){
				i++;
			}
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int[] num = convertToInt(str);
			System.out.println(getBinaryNum(num));
		}
	}

}
