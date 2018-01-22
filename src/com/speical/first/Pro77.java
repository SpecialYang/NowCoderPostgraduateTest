package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 大数浮点数相加
* 
* 数组最大为
* 整数部分最大 + 分数部分最大 + 1（小数点占一位） + 1（整数部分可能进位）
* 
* 然后分别对整数部分和小数部分相加即可
* 
* 注意小数部分需要当小数部分长度相等时才能相加，且若存在进位，要再次和整数部分相加
* @author special
* @date 2018年1月1日 下午4:43:20
*/
public class Pro77 {
	
	public static String doubleAdd(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		int index1 = str1.indexOf('.');
		int index2 = str2.indexOf('.');
		int length = Math.max(index1,index2) 
				+ Math.max(length1 - index1, length2 - index2) + 1;
		char[] result = new char[length];
		Arrays.fill(result, '0');
		int carry = 0, temp;
		int index = Math.max(index1, index2);
		result[index + 1] = '.';  //结果的小数点应该比最大的向后移一位，因为我们之前留了一位要进位
		/**
		 * 整数部分相加
		 */
		for(int i = index1 - 1, j = index2 - 1; i >= 0 || j >= 0; i--, j--){
			if(i >= 0 && j >= 0){
				temp = str1.charAt(i) - '0' + str2.charAt(j) - '0' + carry;
			}else {
				temp = (i >= 0 ? str1.charAt(i) : str2.charAt(j)) - '0' + carry;
			}
			carry = temp / 10;
			temp %= 10;
			result[index--] = (char) (temp + '0');
		}
		if(carry > 0) result[index] = (char) (carry + '0');
		index = length - 1;
		carry = 0;
		/**
		 * 小数部分相加
		 */
		for(int i = length1 - 1, j = length2 - 1; i > index1 || j > index2;){
			if(i > index1 && j > index2 && i - index1 == j - index2){
				temp = str1.charAt(i--) - '0' + str2.charAt(j--) - '0' + carry;
			}else {
				temp = (i - index1 > j - index2 ? str1.charAt(i--) : str2.charAt(j--)) - '0' + carry;
			}
			carry = temp / 10;
			temp %= 10;
			result[index--] = (char) (temp + '0');
		}
		index -= 1;
		while(carry > 0) {
			temp = result[index] - '0' + carry;
			carry = temp / 10;
			temp %= 10;
			result[index--] = (char) (temp + '0');
		}
		int preZero,postZero;
		for(preZero = 0; result[preZero] == '0'; preZero++);
		if(result[preZero] == '.') preZero--;
		for(postZero = length - 1; result[postZero] == '0'; postZero--);
		if(result[postZero] == '.') postZero++;
		return new String(result, preZero, postZero + 1 - preZero);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			for(int i = 0; i < n; i++){
				if(i != 0) input.nextLine();
				String str1 = input.next();
				String str2 = input.next();
				System.out.println(doubleAdd(str1,str2));
			}
		}
	}

}
