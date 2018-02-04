package com.speical.first;

import java.util.Scanner;

/** 
* 判断三边是否能构成三角形
* 
* 我们都知道两边之和大于第三边
* 实际我们不需要三次判断
* 只需判断最大边与其余两边之和的之差就可以了
* @author special
* @date 2018年2月1日 上午10:43:00
*/
public class Pro170 {
	static int[] nums = new int[3];
	
	public static void selectSort(int[] nums){
		int minIndex;
		for(int i = 0; i < nums.length - 1; i++){
			minIndex = i;
			for(int j = i + 1; j < nums.length; j++){
				if(nums[j] < nums[minIndex]){
					minIndex = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = temp;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			for(int i = 0; i < 3; i++){
				nums[i] = input.nextInt();
			}
			selectSort(nums);
			System.out.println(nums[0] + nums[1] - nums[2]);
		}
	}

}
