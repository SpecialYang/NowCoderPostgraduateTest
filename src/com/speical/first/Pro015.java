package com.speical.first;

import java.util.Scanner;

/** 
* root(n,k)
* 
* 有数学推导
* http://www.acmerblog.com/jiudu-1085-2256.html
* @author special
* @date 2017年12月21日 下午8:16:06
*/
public class Pro15 {
	/**
	 * 快速幂求法
	 * @param x
	 * @param y
	 * @param mod
	 * @return
	 */
	public static long fastPower(long x, long y, long mod){
		long sum = 1;
		while(y != 0){
			if((y & 1) == 1) sum = sum * x % mod;
			x = x * x % mod;
			y >>= 1;
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			long x = input.nextLong();
			long y = input.nextLong();
			long k = input.nextLong();
			long result = fastPower(x,y,k - 1);
			System.out.println(result == 0 ? k - 1 : result);
		}
	}

}
