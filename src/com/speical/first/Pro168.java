package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年2月1日 上午10:16:46
*/
public class Pro168 {
	static final int ROW = 2, COL = 3;
	static int[][] matrix1 = new int[ROW][COL], 
				    matrix2 = new int[COL][ROW],
				    result = new int[ROW][ROW];
	
	public static int[][] mutiply(int[][] matrix1, int[][] matrix2){
		int[][] result = new int[ROW][ROW];
		for(int i = 0; i < ROW; i++){
			for(int k = 0; k < ROW; k++){
				for(int j = 0; j < COL; j++){
					result[i][k] += matrix1[i][j] * matrix2[j][k];
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			for(int i = 0; i < ROW; i++){
				for(int j = 0; j < COL; j++){
					matrix1[i][j] = input.nextInt();
				}
			}
			for(int i = 0; i < COL; i++){
				for(int j = 0; j < ROW; j++){
					matrix2[i][j] = input.nextInt();
				}
			}
			result = mutiply(matrix1, matrix2);
			for(int i = 0; i < ROW; i++){
				for(int j = 0; j < ROW; j++){
					System.out.print(result[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
