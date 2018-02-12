package com.speical.first;

import java.util.Scanner;

/** 
* 又是放苹果！！！
* 
* 另见优化方法
* @author special
* @date 2017年12月30日 下午3:22:56
*/
public class Pro60 {
	
	public static int getKinds(int m, int n){
		if(m == 0 || n == 1) return 1;
		if(m < n) return getKinds(m, m);
		return getKinds(m - n,n) + getKinds(m,n - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			System.out.println(getKinds(m,n));
		}
	}

}
