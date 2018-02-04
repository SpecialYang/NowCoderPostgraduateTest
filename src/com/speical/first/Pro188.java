package com.speical.first;

import java.util.Scanner;
/**
 * 矩阵幂
 * 
 * 还有个更好的解法就是 快速矩阵幂（我们将会在improve给出）
 * 思路与求一个数快速幂是一致的
 * @author Special Yang
 * @date 2018年2月4日 下午8:42:56
 */
public class Pro188 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			int k = input.nextInt();
			int[][] sum = new int[n][n], temp = new int[n][n], 
					origin = new int[n][n];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					origin[i][j] = input.nextInt();
					sum[i][j] = 1;
				}
			}
			for(int m = 0; m < k; m++) {
				for(int i = 0; i < n; i++) {
					for(int j = 0; j < n; j++) {
						for(int h = 0; h < n; h++) {
							temp[i][j] += sum[i][h] * origin[h][j];
						}
					}
				}
				for(int j = 0; j < n; j++) {
					for(int h = 0; h < n; h++) {
						sum[j][h] = temp[j][h];
						temp[j][h] = 0;
					}
				}
			}
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					System.out.print((j == 0 ? "" : " ") + sum[i][j]);
				}
				System.out.println();
			}
		}
		input.close();
	}

}
