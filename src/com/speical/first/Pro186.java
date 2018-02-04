package com.speical.first;

import java.util.Scanner;

/** 
* 比较奇偶数的个数
* @author special
* @date 2018年2月4日 上午11:17:18
*/
public class Pro186 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt(), evenCount = 0, oddCount = 0;
			while(n-- > 0){
				if((n & 1) == 0){
					evenCount++;
				}else{
					oddCount++;
				}
			}
			System.out.println(evenCount <= oddCount ? "YES" : "NO");
		}
	}

}
