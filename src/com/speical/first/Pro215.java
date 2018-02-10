package com.speical.first;

import java.util.Scanner;

/**
 * 矩阵的最大值
 * 
 * 正常思路就行
 * @author Special
 * @time 2018/02/10 16:28:30
 */
public class Pro215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int m = input.nextInt();
			int n = input.nextInt();
			int[][] nums = new int[m][n];
			int index, sum, max, num;
			for(int i = 0; i < m; i++) {
				index = 0;
				sum = 0;
				max = Integer.MIN_VALUE;
				for(int j = 0; j < n; j++) {
					num = input.nextInt();
					if(num > max) {
						index = j;
						max = num;
					}
					sum += num;
					nums[i][j] = num;
				}
				nums[i][index] = sum;
			}
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print((j == 0 ? "" : " ") + nums[i][j]);
				}
				System.out.println();
			}
		}
	}

}
