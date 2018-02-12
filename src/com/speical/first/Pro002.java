package com.speical.first;

import java.util.Scanner;

/** 
* 求一个数的约数个数
* @author special
* @date 2017年12月19日 上午9:39:28
*/
public class Pro02 {
	public static int getApproximate(int num){
		int count = 0;
		for(int i = 1; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				count++;
				if(num / i != i){
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			while(n-- > 0){
				int num = input.nextInt();
				int countApproximate = getApproximate(num);
				System.out.println(countApproximate);
			}
		}
	}

}
