package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 整数奇数偶数排序
* 
* 思路：
* 在一个数组做插入排序，这个思路其实最符合题意
* 
* 在左端做奇数的从大到小排序
* 在右端做偶数的从小到大排序
* @author special
* @date 2017年12月30日 下午9:47:04
*/
public class Pro65 {
	static final int SIZE = 10;
	static int[] nums = new int[SIZE];
	
	public static void exch(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			Arrays.fill(nums,0);
			int indexOdd = -1;
			int indexEven = SIZE;
			int num;
			for(int k = 0; k < 10; k++){
				num = input.nextInt();
				if((num & 1) == 1){
					nums[++indexOdd] = num;
					for(int i = indexOdd; i > 0 && nums[i] > nums[i - 1]; i--){
						exch(nums,i,i - 1);
					}
				}else{
					nums[--indexEven] = num;
					for(int i = indexEven; i < SIZE - 1 && nums[i] > nums[i + 1]; i++){
						exch(nums,i,i + 1);
					}
				}
			}
			for(int i = 0; i < SIZE; i++){
				System.out.print((i == 0 ? "" : " ") + nums[i]);
			}
			System.out.println();
		}
	}

}
