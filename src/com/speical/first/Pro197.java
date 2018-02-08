package com.speical.first;

import java.util.Scanner;

/**
 * 调整方阵
 * 
 * 我们通过排序找到每一列最大数所在的行数即可
 * 
 * 不必交换矩阵！！！！！
 * @author Special
 * @time 2018/02/07 23:30:58
 */
public class Pro197 {

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
			int[] indices = new int[n];
			int max = 0;
			boolean[] flag = new boolean[n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(!flag[j]) {
						max = j;
						break;
					}
				}
				for(int j = 0; j < n; j++) {
					if(!flag[j] && nums[j][i] > nums[max][i]) {
						max = j;	
					}
				}
				indices[i] = max;
				flag[max] = true;
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print((j == 0 ? "" : " ") + nums[indices[i]][j]);
				}
				System.out.println();
			}
		}
	}

}
