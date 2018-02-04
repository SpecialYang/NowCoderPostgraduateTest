package com.speical.first;

import java.util.Scanner;

/** 
* 霍夫曼树求权值
* 
* @author special
* @date 2018年2月4日 上午10:52:25
*/
public class Pro185 {
	
	public static void insertSort(int index, int[] weights){
		for(; index < weights.length - 1 && weights[index] > weights[index + 1]; index++){
			int temp = weights[index];
			weights[index] = weights[index + 1];
			weights[index + 1] = temp;
		}
	}
	
	public static void insertSort(int[] weights){
		for(int i = weights.length - 2; i >= 0; i--){
			insertSort(i, weights);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] weights = new int[n];
			for(int i = 0; i < n; i++){
				weights[i] = input.nextInt();
			}
			insertSort(weights);
			int total = 0;
			for(int i = 1; i < n; i++){
				total += weights[i] + weights[i - 1];
				weights[i] += weights[i - 1];
				insertSort(i, weights);
			}
			System.out.println(total);
		}
	}

}
