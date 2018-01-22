package com.speical.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月27日 上午10:10:02
*/
public class Pro41Improve1 {

	public static int[] convertToInt(String str){
		int[] result = new int[str.length()];
		for(int i = 0;i < str.length(); i++){
			result[i] = str.charAt(i) - '0';
		}
		return result;
	}
	public static String getBinaryNum(int[] num){
		StringBuilder sb = new StringBuilder();
		int[] consult = new int[num.length];
		int indexOfCon = 0;
		int r,temp;
		while(indexOfCon < num.length){
			r = 0;
			for(int j = indexOfCon; j < num.length; j++){
				temp = num[j] + r * 10;
				r = temp % 2;
				consult[j] = temp / 2;
			}
			sb.append(r);
			while(indexOfCon < num.length && consult[indexOfCon] == 0){
				indexOfCon++;
			}
			System.arraycopy(consult, indexOfCon, num, indexOfCon, num.length - indexOfCon);
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
