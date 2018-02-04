package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月26日 下午3:19:44
*/
public class Pro150 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			if(m == 0) break;
			int n = input.nextInt();
			int[][] matrix = new int[m][n];
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					matrix[i][j] = input.nextInt();
				}
			}
			int count = 0;
			boolean isAllZero = true;
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					matrix[i][j] += input.nextInt();
					if(isAllZero && matrix[i][j] != 0){
						isAllZero = false;
					}
				}
				count += isAllZero ? 1 : 0;
				isAllZero = true;
			}
			for(int j = 0; j < n; j++){
				for(int i = 0; i < m; i++){
					if(matrix[i][j] != 0){
						isAllZero = false;
						break;
					}
				}
				count += isAllZero ? 1 : 0;
				isAllZero = true;
			}
			System.out.println(count);
		}
	}

}
