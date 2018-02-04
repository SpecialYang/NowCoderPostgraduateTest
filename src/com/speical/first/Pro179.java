package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年2月3日 下午3:46:35
*/
public class Pro179 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt(), x, y, 
				minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
			while(n-- > 0){
				x = input.nextInt();
				y = input.nextInt();
				if(x < minX){
					minX = x;
					minY = y;
				}else if(x == minX && y < minY){
					minY = y;
				}
			}
			System.out.println(minX + " " + minY);
		}
	}
}
