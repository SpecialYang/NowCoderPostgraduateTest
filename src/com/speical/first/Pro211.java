package com.speical.first;

import java.util.Scanner;

/**
 * 找出最大的两个数
 * @author Special
 * @time 2018/02/10 11:03:35
 */
public class Pro211 {
	static final int ROW = 4;
	static final int COL = 5;
	static final int MAX = Integer.MIN_VALUE;
	static int[][] nums = new int[ROW][COL];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			for(int i = 0; i < ROW; i++) {
				for(int j = 0; j < COL; j++) {
					nums[i][j] = input.nextInt();
				}
			}
			int[][] result = new int[2][5];
			int index, max, secondIndex, secondMax;
			for(int i = 0; i < COL; i++) {
				index = 0;
				max = Integer.MIN_VALUE;
				for(int j = 0; j < ROW; j++) {
					if(nums[j][i] > max) {
						index = j;
						max = nums[j][i];
					}
				}
				secondIndex = 0;
				secondMax = Integer.MIN_VALUE;
				for(int j = 0; j < ROW; j++) {
					if(j != index && nums[j][i] > secondMax && 
							nums[j][i] <= max) {
						secondIndex = j;
						secondMax = nums[j][i];
					}
				}
				if(index < secondIndex) {
					result[0][i] = max;
					result[1][i] = secondMax;
				}else {
					result[0][i] = secondMax;
					result[1][i] = max;
				}
			}
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < COL; j++) {
					System.out.print((j == 0 ? "" : " ") + result[i][j]);
				}
				System.out.println();
			}
		}
	}

}
