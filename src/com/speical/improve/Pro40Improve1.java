package com.speical.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月27日 上午9:35:25
*/
public class Pro40Improve1 {
	
	public static int getKinds(int m, int n){
		if(m == 0 || n == 1) return 1;
		if(m < n) return getKinds(m, m);
		return getKinds(m - n, n) + getKinds(m, n - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			while(n-- > 0){
				System.out.println(getKinds(input.nextInt(),input.nextInt()));
			}
		}
	}
}
