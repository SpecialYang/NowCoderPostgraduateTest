package com.speical.improve;

import java.util.Scanner;

/** 
* 递归
* 每一个有票要么选，要么不选
* @author special
* @date 2017年12月21日 下午5:01:32
*/
public class Pro13Improve2 {
	private static int sum;
	private static int[] nums;
	private static int minCount;
	
	public static void dfs(int index, int add, int count){
		if(add == sum) {
			minCount = count;
			return;
		}
		if(index == nums.length) return;
		if(add < sum) {
			dfs(index + 1, add + nums[index], count + 1);
			dfs(index + 1, add, count);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			sum = input.nextInt();
			int n = input.nextInt();
			nums = new int[n];
			for(int i = 0; i < n; i++)
				nums[i] = input.nextInt();
			minCount = 0;
			dfs(0,0,0);
			System.out.println(minCount);
		}
	}
}
