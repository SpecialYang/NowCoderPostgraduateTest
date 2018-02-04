package com.speical.first;

import java.util.Scanner;

/** 
* 最大连续子序列的和
* 
* 动态规划：dp[i] = max{dp[i -1] + nums[i], nums[i]}
* 
* dp[i]表示以i结尾的最大子序列和
* 所以我们只需再用一个全局最大值就可以了
* 至于第一个元素和最后一个元素，当dp[i -1] + nums[i] < nums[i]
* 就可以更新start的值了
* 对于end,不管是不是最大子序列，肯定都是当前的位置i
* @author special
* @date 2018年1月23日 下午10:43:28
*/
public class Pro139 {
	
	public static void solution(int[] nums, int k){
		int max = Integer.MIN_VALUE, pre = 0; 
		int	start = 0, end = k - 1;
		int tempStart = 0, tempEnd = k - 1;
		for(int i = 0; i < k; i++){
			if(pre + nums[i] > nums[i]){
				pre += nums[i];
			}
			else{
				pre = nums[i];
				tempStart = i;
			}
			tempEnd = i;
			if(pre > max){
				start = tempStart;
				end = tempEnd;
				max = pre;
			}
		}
		if(max < 0){
			System.out.println(0 + " " + nums[0] + " " + nums[k - 1]);
		}else{
			System.out.println(max + " " + nums[start] + " " + nums[end]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int k = input.nextInt();
			if(k == 0) break;
			int[] nums = new int[k];
			for(int i = 0; i < k; i++){
				nums[i] = input.nextInt();
			}
			solution(nums, k);
		}
	}

}
