package com.speical.first;

import java.util.Scanner;

/** 
* 小白鼠排序
* 
* 选择排序 + 泛型
* @author special
* @date 2017年12月26日 下午6:53:37
*/
public class Pro36 {
	private static Integer[] weight;
	private static String[] color;
	
	private static <T> void exch(T[] array, int i, int j){
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void selectSort(){
		int length = weight.length;
		int max;
		for(int i = 0; i < length - 1; i++){
			max = i;
			for(int j = i + 1; j < length; j++){
				if(weight[j] > weight[max]){
					max = j;
				}
			}
			exch(weight,i,max);
			exch(color,i,max);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			weight = new Integer[n];
			color = new String[n];
			for(int i = 0; i < n; i++){
				weight[i] = input.nextInt();
				color[i] = input.next();
			}
			selectSort();
			for(String item : color){
				System.out.println(item);
			}
		}
	}

}
