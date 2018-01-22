package com.speical.improve;

import java.util.Scanner;

/** 
* 纯递归会超时
* 若我们用一个cache记录中间值，避免不必要的递归
* 
* @author special
* @date 2017年12月23日 上午11:12:25
*/
public class Pro20Improve1 {
	private static int a0, a1, p, q, MOD = 10000;
	private static int[] cache; //若不缓冲一下，则容易超时
	
	    public static int solve(int n){
	        if(n == 0) return a0;
	        if(n == 1) return a1;
	        if(cache[n] != 0) return cache[n];  
	        return cache[n] = (p * solve(n - 1) + q * solve(n - 2)) % MOD;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			a0 = input.nextInt();
			a1 = input.nextInt();
			p = input.nextInt();
			q = input.nextInt();
			int k = input.nextInt();
			cache = new int[k + 5];
			System.out.println(solve(k) % MOD);
		}
	}
}
