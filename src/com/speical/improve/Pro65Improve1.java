package com.speical.improve;

import java.util.Arrays;
import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月30日 下午10:13:38
*/
public class Pro65Improve1 {
	
	static final int SIZE = 10;
	static int[] nums = new int[SIZE];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			for(int i = 0; i < SIZE; i++){
				nums[i] = input.nextInt();
			}
			Arrays.sort(nums);
			boolean flag = true;
			for(int i = SIZE - 1; i >= 0; i--){
				if((nums[i] & 1) == 1){
					System.out.print((flag ? "" : " ") + nums[i]);
					flag = false;
				}
			}
			for(int i = 0; i < SIZE; i++){
				if((nums[i] & 1) == 0){
					System.out.print((flag ? "" : " ") + nums[i]);
				}
			}
			System.out.println();
		}
	}
}
