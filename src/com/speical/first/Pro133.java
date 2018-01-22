package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 又见 A + B
* 
* 和是int型之和
* 为防止溢出，采用long
* 同时用一个数组来存放每次的余数
* 直到商 为 零为止
* @author special
* @date 2018年1月7日 下午3:46:04
*/
public class Pro133 {
	static int[] nums = new int[40];
	
	public static void add(int m, long a, long b){
		int index = 0;
		long result = a + b;
		do{
			nums[index++] = (int) (result % m);
			result /= m;
		}while(result != 0);
		for(int i = index - 1; i >= 0; i--){
			System.out.print(nums[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			if(m == 0) break;
			int a = input.nextInt();
			int b = input.nextInt();
			Arrays.fill(nums, 0);
			add(m, a, b);
		}
	}

}
