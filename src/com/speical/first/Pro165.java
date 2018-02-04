package com.speical.first;

import java.util.Scanner;

/** 
* 字符串排序
* @author special
* @date 2018年1月31日 下午12:26:32
*/
public class Pro165 {
	
	public static void quickSort(char[] array, int low, int high){
		int point = partition(array, low, high);
		if(point > low){
			quickSort(array, low, point - 1);
		}
		if(point < high){
			quickSort(array, point + 1, high);
		}
	}
	
	public static int partition(char[] array, int low, int high){
		int i = low;
		int j = high;
		while(i < j){
			while(i <= high && array[low] >= array[i]) i++;
			while(j > low && array[low] <= array[j]) j--;
			if(i >= j) break;
			exch(array, i, j);
		}
		if(low < j) exch(array, low, j);
		return j;
	}
	
	private static void exch(char[] array, int i , int j){
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			String str = input.nextLine();
			char[] array = str.toCharArray();
			quickSort(array, 0, array.length - 1);
			System.out.println(new String(array));
		}
	}

}
