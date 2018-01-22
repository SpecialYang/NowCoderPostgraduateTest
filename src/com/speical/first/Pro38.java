package com.speical.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** 
* 大数相除
* 
* 原理与之前的大数进制变换一样
* @author special
* @date 2017年12月26日 下午9:18:28
*/
public class Pro38 {
	private static List<Integer> results;
	
	public static int[] convertToInt(String str){
		int[] result = new int[str.length()];
		for(int i = 0; i < str.length(); i++){
			result[i] = str.charAt(i) - '0';
		}
		return result;
	}
	
	public static void solution(int[] dividend){
		for(int i = 2; i < 10; i++){
			int r = 0;
			int temp = 0;
			for(int j = 0; j < dividend.length; j++){
				temp = r * 10 + dividend[j];
				r = temp % i;
			}
			if(r == 0) results.add(i);
		}
		if(results.size() == 0){
			System.out.println("none");
		}else{
			for(int i = 0; i < results.size(); i++){
				System.out.print((i == 0 ? "" : " ") + results.get(i));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			if(str.equals("-1")) break;
			results = new ArrayList<>();
			int[] dividend = convertToInt(str);
			solution(dividend);
		}
	}

}
