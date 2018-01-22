package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月2日 上午10:33:13
*/
public class Pro81 {
	static int[][] steps = {{1,-1},{1,1},{-1,1},{1,1}}; 
	
	public static int getCount(int num1, int num2){
		if(!(num1 == num2 || num1 - 2 == num2)) return -1;
		int count = 1, x = 1, y = 1;
		while(num1 != x || num2 != y){
			for(int i = 0; i < 4 && (num1 != x || num2 != y); i++){
				x = x + steps[i][0];
				y = y + steps[i][1];
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				int num1 = input.nextInt();
				int num2 = input.nextInt();
				int count = getCount(num1, num2);
				System.out.println(count != -1 ? count : "No Number");
			}
		}
	}

}
