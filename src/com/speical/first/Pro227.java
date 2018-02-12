package com.speical.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 八进制
 * 
 * 其实此模板适合整数类型范围内所有的进制问题
 * 思路就是：
 * 不断对原数取进制的余数，然后除以进制缩小数
 * 直到原数为0
 * 然后最后得到的余数作为高位，之前得到的余数为低位组成我们所要转换后的数
 * 
 * 可以进一步优化，利用位运算
 * @author Special
 * @time 2018/02/11 22:20:23
 */
public class Pro227 {
	static final int SIZE = 8;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int num = input.nextInt();
			List<Integer> octal = new ArrayList<>();
			do {
				octal.add(num % SIZE);
				num /= SIZE;
			}while(num != 0);
			for(int i = octal.size() - 1; i >= 0; i--) {
				System.out.print(octal.get(i));
			}
			System.out.println();
		}
	}

}
