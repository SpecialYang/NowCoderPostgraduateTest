package com.speical.first;

import java.util.Scanner;

/** 
* 买房子
* @author special
* @date 2017年12月30日 下午3:26:47
*/
public class Pro61 {
	static final int PRICE = 200;
	static final int LIMIT = 21;
	
	public static int getYears(int n, double k){
		if(n == PRICE) return 1;
		double price = PRICE;
		int sum = n;
		for(int i = 2; i <= LIMIT; i++){
			sum += n;
			price *= k;
			if(sum >= price) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int k = input.nextInt();
			int years = getYears(n,(100 + k) / 100.0);
			System.out.println(years == -1 ? "Impossible" : years);
		}
	}
}
