package com.speical.first;

import java.util.Scanner;

/** 
* 递归数列
* 
* 用数组遍历即可
* @author special
* @date 2017年12月22日 下午11:24:58
*/
public class Pro20 {
	private static int[] nums;
	private static int p, q, MOD = 10000;
	
	public static int solve(int length){
		for(int i = 2; i <= length; i++){
			nums[i] = (p * nums[i - 1] + q * nums[i - 2]) % MOD;
		}
		return nums[length];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int a0 = input.nextInt();
			int a1 = input.nextInt();
			p = input.nextInt();
			q = input.nextInt();
			int k = input.nextInt();
			nums = new int[k + 5];
			nums[0] = a0;
			nums[1] = a1;
			System.out.println(solve(k));
		}
	}

}
