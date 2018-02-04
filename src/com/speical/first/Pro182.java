package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年2月3日 下午5:28:46
*/
public class Pro182 {
	static int degree;
	//判断2个数组是否相等
	private static boolean isSame(int[][] num1, int[][] num2){
		for(int i = 0; i < num1.length; i++){
			for(int j = 0; j < num1.length; j++){
				if(num1[i][j] != num2[i][j]){
					return false;
				}
			}
		}
		return true;
	}
	/*
	 * 将num1旋转90度
	 */
	public static boolean rotate90(int[][] num1, int[][] num2){
		int length = num1.length;
		int[][] auxilliary = new int[length][length];
		for(int i = 0; i < length; i++){
			System.arraycopy(num1[i], 0, auxilliary[i], 0, length);
		}
		for(int i = 0; i < length; i++){
			for(int j = 0; j < length; j++){
				num1[i][j] = auxilliary[length - j - 1][i];
			}
		}
		degree += 90;
		//若相等，返回即可，否则继续旋转90度,同时注意这里给出递归的终止条件，那就是控制旋转最大的度数
		return isSame(num1, num2) ? true : (degree == 270 ? false : rotate90(num1, num2));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[][] nums1 = new int[n][n];
			int[][] nums2 = new int[n][n];
			degree = 0;
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					nums1[i][j] = input.nextInt();
				}
			}
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					nums2[i][j] = input.nextInt();
				}
			}
			if(isSame(nums1, nums2)){
				System.out.println(degree);
			}else{
				System.out.println(rotate90(nums1,nums2) ? degree : "-1" );
			}
		}
	}

}
