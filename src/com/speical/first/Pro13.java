package com.speical.first;

import java.util.Scanner;

/** 
* ��Ʊ����
* 
* dfs
* ��Ϊһ����Ʊ����ʹ��һ�Σ�����dfs��ʵҲͦ���
* ���ñ�����ά�־�С
* ����dfs���ԣ����һ���ɹ��ģ���Ȼ��������С���Ǹ�·��
* @author special
* @date 2017��12��21�� ����3:54:17
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
