package com.speical.first;

import java.util.Scanner;

/** 
* 合唱队问题
* 
* 其实就是最长递增子序列的变形问题
* 
* 我们的目的是在找一个1234321这样的队形
* 那么我们就分别求以i结尾的从左递增长度ascDp[i]和以i结尾从右递增的长度descDp[i]
* 这样i位置对应的队形长度为ascDp[i] + descDp[i] - 1
* @author special
* @date 2018年1月1日 下午2:51:05
*/
public class Pro71 {
	
	public static int getMinTimes(int[] height){
		int length = height.length;
		int[] ascDp = new int[length + 1];
		int[] descDp = new int[length + 1];
		for(int i = 1; i <= length; i++){
			ascDp[i] = 1;
			descDp[i] = 1;
		}
		for(int i = 1; i <= length; i++){
			for(int j = 1; j < i; j++){
				if(height[j - 1] < height[i - 1]){
					ascDp[i] = Math.max(ascDp[i], ascDp[j] + 1);
				}
			}
		}
		for(int i = length; i >= 1; i--){
			for(int j = length; j > i; j--){
				if(height[j - 1] < height[i - 1]){
					descDp[i] = Math.max(descDp[i], descDp[j] + 1);
				}
			}
		}
		int times = 0;
		for(int i = 1; i <= length; i++){
			times = Math.max(times, ascDp[i] + descDp[i] - 1);
		}
		return length - times;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] height = new int[n];
			for(int i = 0; i < n; i++){
				height[i] = input.nextInt();
			}
			System.out.println(getMinTimes(height));
		}
	}

}
