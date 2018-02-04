package com.speical.first;

import java.util.Scanner;

/** 
* 变形的百鸡问题
* @author special
* @date 2018年1月29日 下午10:24:31
*/
public class Pro153 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			for(int i = 0; i <= n / 5; i++){
				for(int j = 0; j <= (n - i * 5) / 3; j++){
					int k = 100 - i - j;
					if(i * 5 + j * 3 + k * (1.0 / 3) <= n){
						System.out.println("x=" + i + "," + "y=" + j + "," + "z=" + k);
					}
				}
			}
		}
	}

}
