package com.speical.first;

import java.util.Scanner;

/** 
* 贪心法求最大序列和
* 
* 思路用一个sum来保持以第i个结尾的最大值
* 在用一个全局的max来保持最大值
* 我们在sum相加后为负数时，更新为全局最大值后，把sum更新为0
* 因为再相加一个负数时，这是在降低贡献
* @author special
* @date 2017年12月23日 下午2:01:50
*/
public class Pro21 {
	public static long getSequenceMaxSum(long[] nums){
		long max = Long.MIN_VALUE;
		long tempSum = 0;
		for(int i = 0; i < nums.length; i++){
			tempSum += nums[i];
			max = Math.max(max,tempSum);
			if(tempSum < 0){
				tempSum = 0;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			long[] nums = new long[n];
			for(int i = 0; i < n; i++){
				nums[i] = input.nextLong();
			}
			System.out.println(getSequenceMaxSum(nums));
		}
	}

}
