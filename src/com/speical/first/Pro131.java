package com.speical.first;

import java.util.Scanner;

/** 
* 又见A + B
* 
* 两个数有公共长度的后缀，则输出-1
* 否则输出两数之和
* 
* @author special
* @date 2018年1月7日 上午11:54:11
*/
public class Pro131 {
	
	public static int add(int A, int B, int K){
		int result = A + B, digitA, digitB, count = 0;
		while((A != 0 || B != 0) && count < K){
			digitA = A % 10;
			digitB = B % 10;
			if(digitA != digitB) return result;
			A /= 10;
			B /= 10;
			count++;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int A = input.nextInt();
			int B = input.nextInt();
			if(A == 0 && B == 0) break;
			int K = input.nextInt();
			System.out.println(add(A,B,K));
		}
	}

}
