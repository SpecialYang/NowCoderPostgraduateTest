package com.speical.improve;

import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月19日 上午9:45:13
*/
public class Pro02Improve1 {
	
	public static int getApproximate(int num){
		int count = 0;
		int preNum = num - 1;
		for(int i = 1; i <= preNum; i++) count += preNum / i;
		for(int i = 1; i <= num; i++) count -= num / i;
		return -count;
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
