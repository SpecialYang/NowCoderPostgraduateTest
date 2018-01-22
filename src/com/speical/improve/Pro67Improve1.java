package com.speical.improve;

import java.math.BigDecimal;
import java.util.Scanner;

/** 
*
* @author special
* @date 2017年12月31日 下午1:52:01
*/
public class Pro67Improve1 {
	static final int SIZE = 12;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			BigDecimal bd = new BigDecimal("0.00");
			for(int i = 0; i < SIZE; i++){
				bd.add(new BigDecimal(input.next()));
			}
			System.out.format("$%.2f",bd.divide(new BigDecimal(SIZE)));
		}
	}

}
