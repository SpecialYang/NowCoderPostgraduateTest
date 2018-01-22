package com.speical.first;

import java.util.Scanner;


/** 
* 特殊乘法
* @author special
* @date 2017年12月22日 下午10:26:04
*/
public class Pro17 {
	public static int specialMutiple(String n, String m){
		int result = 0;
		for(int i = 0; i < n.length(); i++){
			for(int j = 0; j < m.length(); j++){
				result += (n.charAt(i) - '0') * (m.charAt(j) - '0');
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String[] nums = str.split(" ");
			System.out.println(specialMutiple(nums[0],nums[1]));
		}
	}

}
