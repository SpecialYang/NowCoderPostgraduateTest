package com.speical.first;

import java.util.Scanner;

/** 
* 互换最大值和最小值
* @author special
* @date 2018年1月29日 下午10:35:00
*/
public class Pro154 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] nums = new int[n];
			int min = 0, max = 0;
			for(int i = 0; i < n; i++){
				nums[i] = input.nextInt();
				min = nums[i] < nums[min] ? i : min;
				max = nums[i] > nums[max] ? i : max;
			}
			int temp = nums[min];
			nums[min] = nums[max];
			nums[max] = temp;
			for(int i = 0; i < n; i++){
				System.out.print((i == 0 ? "" : " ") + nums[i]);
			}
			System.out.println();
		}
	}

}
