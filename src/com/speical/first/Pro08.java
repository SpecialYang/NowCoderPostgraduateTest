package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月20日 上午9:55:03
*/
public class Pro08 {
	
	private static void exch(int[] nums, int i , int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void sort(int[] snos, int[] grades){
		for (int i = 1; i < snos.length; i++)
			for (int j = i; j > 0 ; j--) {
				if(grades[j] < grades[j - 1]){
					exch(snos, j, j - 1);
					exch(grades, j, j - 1);
				}else if(grades[j] == grades[j - 1] && snos[j] < snos[j - 1]){
					exch(snos, j, j - 1);
				}
			}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] snos = new int[n];
			int[] grades = new int[n];
			for(int i = 0; i < n; i++){
				snos[i] = input.nextInt();
				grades[i] = input.nextInt();
			}
			sort(snos,grades);
			for(int i = 0; i < n; i++)
				System.out.println(snos[i] + " " + grades[i]);
		}
	}

}
