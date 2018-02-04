package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月25日 上午11:30:46
*/
public class Pro147 {
	static final int MIN = Integer.MIN_VALUE;
	static final int MAX = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n, m;
		while(input.hasNext()){
			n = input.nextInt();
			m = input.nextInt();
			if(n == 0 && m == 0) break;
			int minX = MAX, maxX = MIN, minY = MAX, maxY = MIN;
			while(!(n == 0 && m == 0)){
				minX = Math.min(minX, n);
				maxX = Math.max(maxX, n);
				minY = Math.min(minY, m);
				maxY = Math.max(maxY, m);
				n = input.nextInt();
				m = input.nextInt();
			}
			System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
		}
	}

}
