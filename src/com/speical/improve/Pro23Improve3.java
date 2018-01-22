package com.speical.improve;

import java.util.Scanner;

/** 
* 我们用一个int数组来保存大数
* 也就是说数组中的每一位都是4位整数
* 比如10000 表示为 a[0] = 0000 a[1] = 1;
* 然后让 1 到 1000 分别乘就可以了
* 这个不适合 两个大数相乘，只是适合单方面乘
* @author special
* @date 2017年12月23日 下午5:05:08
*/
public class Pro23Improve3 {
	private static final int SIZE = 10000;
	
	public static void getFactories(int n){
		int[] res = new int[SIZE];
		res[0] = 1;
		int digit = 0;
		int carry = 0;
		for(int i = 2; i <= n; i++,carry = 0){
			for(int j = 0; j <= digit; j++){
				res[j] = res[j] * i + carry;
				carry = res[j] / SIZE;
				res[j] %= SIZE;
			}
			if(carry > 0) res[++digit] = carry;
		}
		System.out.print(res[digit--]);
		for(int i = digit; i >= 0; i--){
			System.out.format("%04d", res[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			getFactories(n);
		}
	}

}
