package com.speical.first;

import java.util.Scanner;

/**
 * C 翻转
 * @author Special
 * @date 2018年2月4日 下午9:12:38
 */
public class Pro189 {
	static final int SIZE = 5;
	static int[][] nums = new int[SIZE][SIZE];
	static int[][] aux = new int[SIZE][SIZE];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			for(int i = 0; i < SIZE; i++) {
				for(int j = 0; j < SIZE; j++) {
					nums[i][j] = input.nextInt();
					aux[i][j] = nums[i][j];
				}
			}
			int kind = input.nextInt();
			int count = input.nextInt();
			int startX = input.nextInt() - 1;
			int startY = input.nextInt() - 1;
			int endX = startX + count - 1;
			int endY = startY + count - 1;
			
			for(int i = startX; i <= endX; i++) {
				for(int j = startY; j <= endY; j++) {
					if(kind == 1) {
						nums[i][j] = aux[endX - (j - startY)][startY + (i - startX)];
					}
					else if(kind == 2) {
						nums[i][j] = aux[startX + (j - startY)][endY - (i - startX)];
					}
				}
			}
			for(int i = 0; i < SIZE; i++) {
				for(int j = 0; j < SIZE; j++) {
					System.out.print((j == 0 ? "" : " ") + nums[i][j]);
				}
				System.out.println();
			}
		}
	}

}
