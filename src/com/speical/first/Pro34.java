package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 真分数也就是分母比分子小，且2者的最大公约数为1
* @author special
* @date 2017年12月25日 下午2:28:44
*/
public class Pro34 {
	private static int gcd(int n, int m){
		return n % m == 0 ? m : gcd(m,n % m);
	}
	public static int getProperFraction(int[] nums){
		int count = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 1; i++){
			for(int j = i + 1; j < nums.length; j++){
				if (nums[j] > nums[i] && gcd(nums[j],nums[i]) == 1) {
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			int[] nums = new int[n];
			for(int i = 0; i < n; i++){
				nums[i] = input.nextInt();
			}
			System.out.println(getProperFraction(nums));
		}
	}

}
