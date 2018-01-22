package com.speical.first;

import java.util.Scanner;

/** 
*
* @author special
* @date 2018年1月1日 下午11:30:59
*/
public class Pro80 {
	/**
	 * 插入排序
	 * 比较规则为字符串长度比较
	 * @param strs
	 * @param length
	 */
	public static void insertSort(String[] strs, int length){
		for(int i = 1; i < length; i++){
			for(int j = i; j > 0 && strs[j].length() < strs[j - 1].length(); j--){
				String temp = strs[j];
				strs[j] = strs[j - 1];
				strs[j - 1] = temp;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			String[] strs = new String[n];
			int index = 0;
			input.nextLine();
			for(int i = 0; i < n; i++){
				String str = input.nextLine();
				if(str.equals("stop")) break;
				strs[index++] = str;
			}
			insertSort(strs, index);
			for(int i = 0; i < index; i++){
				System.out.println(strs[i]);
			}
		}
	}

}
