package com.speical.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 输出数组中的所有极值的下标
* @author special
* @date 2017年12月29日 下午2:32:59
*/
public class Pro53 {
	public static void getExtremum(int[] nums){
		if(nums.length == 1){
			System.out.println(0);
			return;
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums.length; i++){
			if(i == 0){
				if(nums[i] != nums[i + 1]){
					list.add(i);
				}
			}else if(i == nums.length - 1){
				if(nums[i] != nums[i - 1]){
					list.add(i);
				}
			}else{
				if(nums[i] < nums[i - 1] && nums[i] < nums[i + 1]
						|| nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
					list.add(i);
				}
			}
		}
		for(int i = 0; i < list.size(); i++){
			System.out.print((i == 0 ? "" : " ") + list.get(i));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				int m = input.nextInt();
				int[] nums = new int[m];
				for(int i = 0; i < m; i++){
					nums[i] = input.nextInt();
				}
				getExtremum(nums);
			}
		}
	}

}
