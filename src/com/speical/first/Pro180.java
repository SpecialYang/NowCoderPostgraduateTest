package com.speical.first;

import java.util.Scanner;

/** 
* 素数
* @author special
* @date 2018年2月3日 下午3:53:05
*/
public class Pro180 {
	static final int SIZE = 10000 + 5;
	static boolean[] notIsPrime = new boolean[SIZE];
	
	public static void init(){
		for(int i = 2; i < SIZE; i++){
			if(!notIsPrime[i]){
				for(int j = i + i; j < SIZE; j += i){
					notIsPrime[j] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			boolean start = true;
			for(int i = 2; i < n; i++){
				if(!notIsPrime[i]){
					if(i % 10 == 1){
						System.out.print((start ? "" : " ") + i);
						start = false;
					}
				}
			}
			System.out.println(start ? "-1" : "");
		}
	}

}
