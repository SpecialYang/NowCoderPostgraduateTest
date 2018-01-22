package com.speical.first;

import java.util.Scanner;

/** 
* 成绩排序
* @author special
* @date 2017年12月18日 下午11:35:31
*/
public class Pro01 {
	private static String[] names;
	private static int[] grades;
	private static boolean compare(int i, int j, int flag){
		return flag == 0 ? grades[i] > grades[j] : grades[i] < grades[j];
	}
	private static void exch(int i, int j){
		String tempS = names[j];
		int tempG = grades[j];
		names[j] = names[i];
		grades[j] = grades[i];
		names[i] = tempS;
		grades[i] = tempG;
	}
	public static void sort(int flag){
		for(int i = 1; i < names.length; i++)
			for(int j = i; j > 0 && compare(j,j - 1,flag); j--){
				exch(j,j - 1);
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int flag = input.nextInt();
			names = new String[n];
			grades = new int[n];
			for(int i = 0; i < n; i++){
				names[i] = input.next();
				grades[i] = input.nextInt();
			}
			sort(flag);
			for(int i = 0; i < n; i++){
				System.out.println(names[i] + " " + grades[i]);
			}
		}
	}

}
