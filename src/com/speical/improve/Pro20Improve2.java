package com.speical.improve;

import java.util.Scanner;

/** 
* 优化
* 
* 不用数组，只是用两个变量保持前后就行。
* @author special
* @date 2017年12月23日 上午11:30:13
*/
public class Pro20Improve2 {
	private static int a0, a1, p, q, MOD = 10000;
	
	    public static int solve(int n){
	       if(n == 0) return a0;
	       if(n == 1) return a1;
	       int pre = a0;
	       int cur = a1;
	       while(n-- >= 2){
	    	   int temp = cur;
	    	   cur = (p * cur + q * pre) % MOD;
	    	   pre = temp;
	       }
	       return cur;
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
			System.out.println(solve(k));
		}
	}
}
