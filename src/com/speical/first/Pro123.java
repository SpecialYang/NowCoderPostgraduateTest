package com.speical.first;

import java.util.Scanner;

/** 
* 火星A + B
* 
* 素数打表 + 大数相加
* 
* 注意此题的数每一位可能超过一位
* 所以相加时不能用以往的char数组
* 老老实实用int数组省事
* 
* 期待大家的优化
* @author special
* @date 2018年1月6日 上午11:48:29
*/
public class Pro123 {
	static final int SIZE = 30;
	static int[] prime = new int[SIZE];
	
	public static boolean isPrime(int num){   //判断是否是素数
		for(int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
	
	public static void init(){  //获得前29个素数
		int index = 1;
		for(int n = 2; index < SIZE; n++){
			if(isPrime(n)){
				prime[index++] = n;
			}
		}
	}
	
	public static int[] convertInt(String str){ //输入的火星文转换成int数组，数的低位对应数组的高位
		String[] nums = str.split(",");
		int[] num = new int[nums.length];
		int temp;
		for(int i = 0; i < nums.length; i++){
			temp = 0;
			for(int j = 0; j < nums[i].length(); j++){
				temp = temp * 10 + nums[i].charAt(j) - '0';
			}
			num[i] = temp;
		}
		return num;
	}
	public static void add(String A, String B){ // 火星文相加
		int[] num1 = convertInt(A);
		int[] num2 = convertInt(B);
		int[] result = new int[Math.max(num1.length, num2.length) + 1]; //结果的数组大小最大为相加两个数的最大 + 1
		int index = result.length, carry = 0, temp, redix = 1;
		for(int i = num1.length - 1, j = num2.length - 1; i >= 0 || j >= 0; i--, j--){
			temp = (i >= 0 ? num1[i] : 0) + (j >= 0 ? num2[j] : 0) + carry;
			carry = temp / (prime[redix]);
			temp %= prime[redix++];
			result[--index] = temp;
		}
		if(carry > 0){
			result[--index] = carry;
		}
		boolean flag = true;
		for(int i = index; i < result.length; i++){  // 根据结果数组打印
			System.out.print((flag ? "" : ",") + result[i]);
			flag = false;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String A = input.next();
			String B = input.next();
			if(A.equals("0") || B.equals("0")) break;
			add(A, B);
		}
	}	

}
