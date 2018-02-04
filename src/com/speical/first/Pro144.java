package com.speical.first;

import java.util.Scanner;

/** 
* Hello world for U
* 
* 思路很简单，n2的最小值为 (str.length + 2) / 3
* 同时上述也是n1, n3 的最大值
* 然后我们不断对n2加1，直到 n1 + n2 + n3 = str.length + 2即可
* @author special
* @date 2018年1月25日 上午10:24:41
*/
public class Pro144 {
	
	public static int[] getN1(String str){
		int[] ns = new int[2];
		int length = str.length() + 2;
		ns[1] = length / 3; 
		ns[0] = ns[1];
		while(ns[0] + ns[1] + ns[0] != length){
			ns[1] += 1;
		}
		return ns;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			int[] ns = getN1(str);
			StringBuilder sb = new StringBuilder();
			int count = 0;
			while(count++ < ns[1] - 2){
				sb.append(" ");
			}
			for(int i = 0; i < ns[0] - 1; i++){
				System.out.println(str.charAt(i) + sb.toString() + str.charAt(str.length() - 1 - i));
			}
			System.out.println(str.substring(ns[0] - 1, ns[1] + ns[0] - 1));
		}
	}

}
