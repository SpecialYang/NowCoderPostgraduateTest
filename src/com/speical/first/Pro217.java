package com.speical.first;

import java.util.Scanner;

/**
 * 判断对称矩阵
 * 
 * 注意我的循环的边界条件，对角线是不用参与比较，所以去掉
 * @author Special
 * @time 2018/02/10 17:28:02
 */
public class Pro217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			int[][] nums = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					nums[i][j] = input.nextInt();
				}
			}
			boolean flag = true;
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < n - 1; j++) {
					if(nums[i][j] != nums[j][i]) {
						flag = false;
						break;
					}
				}
			}
			System.out.println(flag ? "Yes!" : "No!");
		}
	}

}
