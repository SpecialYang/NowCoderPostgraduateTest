package com.speical.improve;

import java.util.Scanner;

/**
 * 八进制
 * 
 * 思路:因为8进制正好对应3位二进制
 * 故我们可以对一个数每次与7相与截取一个数（其实这就是八进制的数）
 * 然后要把这个数乘以控制位数的值，因为我们每次截取的值都要向高位进一位
 * 利用base即可存储控制位数的值的中间状态
 * 之后还要把原数无符号的向右移位3位，相等于除以8
 * @author Special
 * @time 2018/02/12 21:42:11
 */
public class Pro227Improve1 {
	static final int SIZE = 7;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
			int num = input.nextInt();
			int result = 0;
			int base = 1;
			while(num != 0) {
				result += base * (num & SIZE);
				num >>>= 3;
				base *= 10;
			}
			System.out.println(result);
		}
	}

}
