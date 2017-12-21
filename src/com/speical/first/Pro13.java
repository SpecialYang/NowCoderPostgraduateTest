package com.speical.first;

import java.util.Scanner;

/** 
* 邮票问题
* 
* dfs
* 因为一张有票可以使用一次，所以dfs其实也挺快的
* 不用变量来维持就小
* 根据dfs特性，最后一个成功的，必然是数量最小的那个路径
* @author special
* @date 2017年12月21日 下午3:54:17
*/
public class Pro13 {
	private static int sum;
	private static int[] nums;
	private static int minCount;
	
	public static void dfs(int index, int add, int count){
		if(add > sum) return;
		if(add == sum) {
			minCount = count;
			return;
		}
		for(int i = index + 1; i < nums.length; i++)
			dfs(i, add + nums[i], count + 1);
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
			dfs(-1,0,0);
			System.out.println(minCount);
		}
	}

}
