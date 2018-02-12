package com.speical.first;

import java.math.BigInteger;
import java.util.Scanner;

/** 
* m进制的数转换为n进制
* @author special
* @date 2017年12月24日 下午4:51:17
*/
public class Pro29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			String str = input.next();
			String numStr = new BigInteger(str,m).toString(n);
			System.out.println(numStr);
		}
	}

}
