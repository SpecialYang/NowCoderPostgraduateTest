

package com.speical.first;

import java.util.Scanner;

/** 
* 树根
* 
* 如果一个数的所有位数相加是一个单个数位，则它就是数的根
* 否则对新得到数重复以上，直到是一个单个数位为止
* 
* 公式：digitRoot = num % (redix - 1)  redix表示num采用的进制
* @author special
* @date 2017年12月31日 上午10:58:37
*/
public class Pro70 {
	static final int SIZE = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			int result = n % (SIZE - 1);
			System.out.println(result == 0 ? 9 : result);
		}
	}

}
