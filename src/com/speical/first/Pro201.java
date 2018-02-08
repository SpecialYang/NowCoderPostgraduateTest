package com.speical.first;

import java.util.Scanner;

/**
 * 矩阵转置
 * 
 * 方阵的转置相对简单，可以利用对角线交换即可
 * @author Special
 * @time 2018/02/08 15:44:10
 */
public class Pro201 {

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
			int temp;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < i; j++) {
					temp = nums[i][j];
					nums[i][j] = nums[j][i];
					nums[j][i] = temp;
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print((j == 0 ? "" : " ") + nums[i][j]);
				}
				System.out.println();
			}
		}
	}

}
