package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月24日 上午11:06:30
*/
public class Pro141 {
	
	public static int[] merge(int[] num1, int[] num2){
		int index = 0, index1 = 0, index2 = 0;
		int[] result = new int[num1.length + num2.length];
		while(index1 < num1.length && index2 < num2.length){
			if(num1[index1] <= num2[index2]){
				result[index++] = num1[index1++];
			}else{
				result[index++] = num2[index2++];
			}
		}
		while(index1 < num1.length){
			result[index++] = num1[index1++];
		}
		while(index2 < num2.length){
			result[index++] = num2[index2++];
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int[] num1 = new int[n];
			for(int i = 0; i < n; i++){
				num1[i] = input.nextInt();
			}
			n = input.nextInt();
			int[] num2 = new int[n];
			for(int i = 0; i < n; i++){
				num2[i] = input.nextInt();
			}
			int[] merge = merge(num1, num2);
			System.out.println(merge[(merge.length - 1) / 2]);
		}
	}

}
