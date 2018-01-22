
package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 
* 最大子矩阵问题
* 
* 连续序列最大和的变形
* 思路很好：
* 因为每一个矩阵都可以拍成一个行向量，即一个数组
* 任何一个子矩阵都可以看成是列相加拍成的一个行向量（即连续序列）
* 又因为一个子矩阵拍成的行向量包含于正好包住它的大矩阵拍成的行向量。
* 问题就转化为了在一组数中找出连续序列最大和的问题
* 
* 所以我们要对每一个大矩阵（可以行为主，或列为主）求最大连续和就可以，用一个max维持全局最大
* @author special
* @date 2017年12月30日 下午4:13:16
*/
public class Pro62 {
	
	public static int getConsequenceSum(int[] nums){
		int max = Integer.MIN_VALUE;
		int pre = 0;
		for(int i = 0; i < nums.length; i++){
			pre = Math.max(pre + nums[i], nums[i]);
			max = Math.max(max,pre);
		}
		return max;
	}
	
	public static int getMaxSum(int[][] nums, int n){
		int[] temp = new int[n];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++){       //起始行
			for(int j = i; j < n; j++){   //终止行
				for(int k = 0; k < n; k++){  //每一行的列
					temp[k] += nums[j][k];
				}
				max = Math.max(max,getConsequenceSum(temp));
			}
			Arrays.fill(temp,0);
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[][] nums = new int[n][n];
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					nums[i][j] = input.nextInt();
				}
			}
			System.out.println(getMaxSum(nums,n));
		}
	}

}
