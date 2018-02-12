package com.speical.first;

import java.util.Scanner;

/**
 * 阶乘
 * 
 * 每次循环保存中间状态很关键
 * 然后通过判断本次是偶数还是奇数，就可以分别累加到不同的分支上。
 * @author Special
 * @time 2018/02/11 22:09:44
 */
public class Pro226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int n = input.nextInt();
			int y1 = 0, y2 = 0, result = 1;
			for(int i = 1; i <= n; i++) {
				result *= i;
				if((i & 1) == 1) {
					y1 += result;
				}else {
					y2 += result;
				}
			}
			System.out.println(y1 + " " + y2);
		}
	}

}
