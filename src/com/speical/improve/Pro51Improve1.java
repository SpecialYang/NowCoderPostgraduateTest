package com.speical.improve;

import java.util.Scanner;

/** 
* 看当前最高位是否为1来模拟循环左移
* @author special
* @date 2017年12月28日 下午3:53:02
*/
public class Pro51Improve1 {
	static final int SIZE = 16;
	
	public static boolean isCycle(int n, int m){
		for(int i = 0; i < SIZE; i++){
			if(n == m){
				return true;
			}
			/**
			 * 就是看看当前最高位是否为1，这样的话我们左移之后
			 * 末尾要根据如此来决定是否加1，来模拟循环左移
			 * n = (n << 1) & 65535;这一步很关键，因为我们采用的int
			 * 若不这样做，会导致数变大，且模拟不成功
			 * Java中都是有符号的数，所以short的最大值才是2的15次方减一
			 */
			if((n & (1 << 15)) != 0){
				n = (n << 1) & 65535; 
				n++;
			}else{
				n <<= 1;
			}
		}
		return false;
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
