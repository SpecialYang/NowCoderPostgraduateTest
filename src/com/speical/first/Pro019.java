package com.speical.first;


/** 
* 完数和盈数
*
* @author special
* @date 2017年12月22日 下午10:59:03
*/
public class Pro19 {
	public static int check(int num){
		int sum = 1;
		for(int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				sum += i;
				if(num / i != i){
					sum += num / i;
				}
				if(sum > num){
					return 1;
				}
			}
		}
		if(sum == num) return 0;
		else return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] E = new int[60];
		int[] G = new int[60];
		int indexE = 0;
		int indexG = 0;
		for(int i = 2; i <= 60; i++){
			if(check(i) == 0){
				E[indexE++] = i;
			}else if(check(i) == 1){
				G[indexG++] = i;
			}
		}
		System.out.print("E:");
		for(int i = 0; i < indexE; i++){
			System.out.print(" " + E[i]);
		}
		System.out.print("\nG:");
		for(int i = 0; i < indexG; i++){
			System.out.print(" " + G[i]);
		}
		System.out.println();
	}

}
