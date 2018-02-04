package com.speical.first;

import java.util.Scanner;

/** 
* 数字阶梯求和
* 
* 大数相加即可，对于每一位的结果为a * 有这个位的数的个数 + 进位
* 然后我们用一个数组存储结果，末尾对应结果的地位
* @author special
* @date 2018年1月31日 下午12:15:36
*/
public class Pro164 {
	
	public static void sum(int a, int n){
		int[] result = new int[n + (int)(Math.log10(n)) + 1];
		int temp, carry = 0, index = result.length;
		for(int i = n; i > 0; i--){
			temp = a * i + carry;
			carry = temp / 10;
			temp %= 10;
			result[--index] = temp;
		}
		while(carry > 0) {
			result[--index] = carry % 10;
			carry /= 10;
		}
		int i = 0;
		for(; i < result.length && result[i] == 0; i++);
		for(; i < result.length; i++){
			System.out.print(result[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int a = input.nextInt();
			int n = input.nextInt();
			sum(a, n);
		}
	}

}
