package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 求中位数
* 
* 如果数组大小为偶数，则为中间两个的平均值
* 如果数组大小为奇数，则为中间的一个
* 
* 复杂度取决于排序算法的复杂度
* @author special
* @date 2017年12月25日 下午2:47:19
*/
public class Pro35 {
	public static int getMedian(int[] nums){
		Arrays.sort(nums);
		int avg = nums.length / 2;
		if((nums.length & 1) == 0){ // 只需判断最后一位是否1即可判断是否是偶数
			return (nums[avg - 1] + nums[avg]) / 2;
		}else
			return nums[avg];
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
			System.out.println(getMedian(nums));
		}
	}

}
