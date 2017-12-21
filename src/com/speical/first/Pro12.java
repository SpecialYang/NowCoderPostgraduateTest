package com.speical.first;

import java.util.Scanner;

/** 
* 最大值最小值
* 贪心
* 
* 复杂度为n,只要每次输入一个值，保持局部最小和最大就行了
* @author special
* @date 2017年12月21日 下午3:27:15
*/
public class Pro12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			while(n-- > 0){
				int num = input.nextInt();
				if(num > max) max = num;
				if(num < min) min = num;
			}
			System.out.println(max + " " + min);
		}
	}

}
