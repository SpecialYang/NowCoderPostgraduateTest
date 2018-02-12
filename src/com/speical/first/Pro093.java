package com.speical.first;

import java.util.Scanner;

/** 
* 求组成数的最大数且能整除给定的除数
* @author special
* @date 2018年1月3日 上午10:47:08
*/
public class Pro093 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int num = 0;
			for(int i = 0; i < 3; i++){
				num = num * 10 + input.nextInt();
			}
			boolean flag = false;
			int totoal = 0, temp, i = 9, j = 9;
			for(; i >= 1; i--){
				temp = i * 1000 + num;
				for(j = 9; j >= 0; j--){
					totoal = temp * 10 + j;
					if(totoal % n == 0){
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			System.out.println(flag ? i + " " 
							  + j + " " + totoal / n : "0");
		}
	}

}
