package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 循环移位二进制问题
* 
* 其实问题转换为一个字符串是否能由另一个字符串循环移位得到
* 我们先把其中一个字符串，扩展了成它自身的2倍，
* 然后看能否在这个扩展的字符串找到另一个字符串
* 
* 比如求1234 是否能够 旋转得到 3412
* 
* 扩展1234为12341234，在其中能够找到3412，故可以得到
* @author special
* @date 2017年12月28日 下午3:10:51
*/
public class Pro51 {
	static final int SIZE = 16;
	/**
	 * 求一个数的二进制位
	 * 参考jdk
	 * @param n
	 * @return
	 */
	private static String toBinary(int n){
		char[] digit = new char[SIZE];
		Arrays.fill(digit, '0');
		int index = 16;
		do{
			digit[--index] = ((n & 1) == 1) ? '1' : '0';
			n >>>= 1;
		}while(n != 0);
		return new String(digit);
	}
	
	public static boolean isCycle(int n, int m){
		String binaryN = toBinary(n);
		binaryN = binaryN + binaryN;
		String binaryM = toBinary(m);
		return binaryN.contains(binaryM);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int num = input.nextInt();
			while(num-- > 0){
				int n = input.nextInt();
				int m = input.nextInt();
				System.out.println(isCycle(n, m) ? "YES" : "NO");
			}
		}
	}

}
