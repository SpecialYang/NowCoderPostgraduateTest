package com.speical.first;

import java.util.Scanner;

/**
 * 多项式求和
 * 
 * 测试用例是错的，后台其实是圣升序的
 * @author Special
 * @time 2018/02/08 11:30:14
 */
public class Pro199 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n1 = input.nextInt();
			int[] coefficient1 = new int[n1], exponent1 = new int[n1];
			for(int i = 0; i < n1; i++) {
				coefficient1[i] = input.nextInt();
				exponent1[i] = input.nextInt();
			}
			int n2 = input.nextInt();
			int[] coefficient2 = new int[n2], exponent2 = new int[n2];
			for(int i = 0; i < n2; i++) {
				coefficient2[i] = input.nextInt();
				exponent2[i] = input.nextInt();
			}
			int[] resultCoe = new int[n1 + n2], resultExp = new int[n1 + n2];
			int index1 = coefficient1.length - 1, index2 = coefficient2.length - 1, index = 0;
			while(index1 >= 0 && index2 >= 0) {
				if(exponent1[index1] == exponent2[index2]) {
					resultExp[index] = exponent1[index1];
					resultCoe[index++] = coefficient1[index1--] + coefficient2[index2--];
				}else if(exponent1[index1] > exponent2[index2]){
					resultExp[index] = exponent1[index1];
					resultCoe[index++] = coefficient1[index1--];
				}else if(exponent1[index1] < exponent2[index2]) {
					resultExp[index] = exponent2[index2];
					resultCoe[index++] = coefficient2[index2--];
				}
			}
			while(index1 >= 0) {
				resultExp[index] = exponent1[index1];
				resultCoe[index++] = coefficient1[index1--];
			}
			while(index2 >= 0) {
				resultExp[index] = exponent2[index2];
				resultCoe[index++] = coefficient2[index2--];
			}
			boolean flag = false;
			for(int i = 0; i < index; i++) {
				if(resultCoe[i] != 0) {
					System.out.print((!flag ? "" : " ") + resultCoe[i] + " " + resultExp[i]);
					flag = true;
				}
			}
			System.out.println();
		}
	}

}
