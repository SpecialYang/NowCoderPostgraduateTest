package com.speical.first;

import java.util.Scanner;

/**
 * 奇校验
 * 就是检测给定数的二进制数中1的个数是否为奇数，若不为奇数，说明传输中出现错误
 * 所以我们在发送端，需要事先用一个奇校验位来表示数的1的个数。
 * 在奇校验中，始终保持数的二进制的1的个数为奇数，若为偶数，会让数的最高位为1
 * 从而保持这个数的有奇数个1
 * @author Special
 * @time 2018/02/09 14:46:33
 */
public class Pro210 {
	
	public static void oddCheck(char ch) {
		int[] digits = new int[8];
		int count = 0;
		int base = 1;
		int index = 8;
		do{
			digits[--index] = ch & base;
			if((digits[index] & 1) == 1) {
				count++;
			}
			ch >>>= 1;
		}while(ch != 0); //这样的做法可以减少不必要的循环，因为若数为0，就没必须统计1的个数
		if((count & 1) == 0) { digits[0] = 1; }
		for(int i = 0; i < 8; i++) {
			System.out.print(digits[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			String str = input.nextLine();
			for(int i = 0; i < str.length(); i++) {
				oddCheck(str.charAt(i));
				System.out.println();
			}
		}
	}

}
