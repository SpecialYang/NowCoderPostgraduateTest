package com.speical.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月28日 下午4:19:38
*/
public class Pro51Improve2 {
static final int SIZE = 16;
	
	public static boolean isCycle(int n, int m){
		for(int i = 0; i < SIZE; i++){
			if((((n << i) & 65535) | (n >> (SIZE - i))) == m){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			while(num-- > 0){
				int n = input.nextInt();
				int m = input.nextInt();
				System.out.println(isCycle(n, m) ? "YES" : "NO");
			}
		}
	}

}
