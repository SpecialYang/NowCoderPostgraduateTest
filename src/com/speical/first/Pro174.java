package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年2月2日 上午10:01:10
*/
public class Pro174 {
	
	public static boolean judge(int n){
		boolean flag = false;
		int quare;
		for(int i = 2; i <= Math.sqrt(n); i++){
			quare = i * i;
			if(n % quare == 0){
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.println(judge(n) ? "YES" : "NO");
		}
	}

}
