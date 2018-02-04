package com.speical.first;

import java.util.Scanner;

/** 
* 找X
* @author special
* @date 2018年1月30日 上午10:23:10
*/
public class Pro155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] nums = new int[n];
			for(int i = 0; i < n; i++){
				nums[i] = input.nextInt();
			}
			int num = input.nextInt();
			int i = 0;
			for(i = 0; i < n; i++){
				if(nums[i] == num){
					break;
				}
			}
			System.out.println(i >= n ? -1 : i);
		}
	}

}
