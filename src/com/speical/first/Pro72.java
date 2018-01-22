package com.speical.first;

import java.util.Scanner;

/** 
* 字符串中的字符按ascii码
* 次处用的是经典的冒泡排序法（注意如何更好的控制循环范围）
* 
* 当然可以使用桶排序哈
* @author special
* @date 2018年1月1日 下午3:06:54
*/
public class Pro72 {
	
	public static String bubbleSort(String str){
		char[] array = str.toCharArray();
		for(int i = 0; i < str.length() - 1; i++){
			for(int j = 0; j < str.length() - i - 1; j++){
				if(array[j] > array[j + 1]){
					char temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return new String(array);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub.
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			System.out.println(bubbleSort(str));
		}
	}

}
