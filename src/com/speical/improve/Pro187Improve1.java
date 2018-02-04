package com.speical.improve;

import java.util.Arrays;
import java.util.Scanner;

/** 
*
* @author special
* @date 2018年2月4日 上午11:59:22
*/
public class Pro187Improve1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++){
				nums[i] = input.nextInt();
			}
			int k = input.nextInt(), index = 1;
			Arrays.sort(nums);
			for(int i = 0; i < n;){
				if(index == k) {
					System.out.println(nums[i]);
					break;
				}
				while((++i) < n && nums[i] == nums[i - 1]);
				if(i < n) {
					index++;
				}
			}
		}
		input.close();
	}

}
