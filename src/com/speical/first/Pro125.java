package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月6日 下午2:06:18
*/
public class Pro125 {
	static final int SIZE = 65536;
	static int[] map = new int[SIZE];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str1 = input.nextLine();
			if(str1.equals("#")) break;
			String str2  = input.nextLine();
			Arrays.fill(map, 0);
			for(int i = 0; i < str2.length(); i++){
				map[str2.charAt(i)]++;
			}
			for(int i = 0; i < str1.length(); i++){
				System.out.println(str1.charAt(i) + " " + map[str1.charAt(i)]);
			}
		}
	}

}
