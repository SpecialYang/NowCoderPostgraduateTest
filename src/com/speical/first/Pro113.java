package com.speical.first;

import java.util.Scanner;

/** 
* 后缀字符串排序问题
* 
* 我这里选择的是选择排序
* @author special
* @date 2018年1月5日 上午10:12:37
*/
public class Pro113 {
	
	public static void selectSort(String[] suffix){
		int min;
		for(int i = 0; i < suffix.length - 1; i++){
			min = i;
			for(int j = i + 1; j < suffix.length; j++){
				if(suffix[j].compareTo(suffix[min]) < 0){
					min = j;
				}
			}
			if(min != i){
				String temp = suffix[min];
				suffix[min] = suffix[i];
				suffix[i] = temp;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			String[] suffix = new String[str.length()];
			for(int i = str.length() - 1; i >= 0; i--){
				suffix[i] = str.substring(i, str.length());
			}
			selectSort(suffix);
			for(int i = 0; i < suffix.length; i++){
				System.out.println(suffix[i]);
			}
		}
	}

}
