package com.speical.improve;

import java.util.Scanner;
import java.util.Stack;

/** 
* 利用两个数组来做
* @author special
* @date 2017年12月24日 下午11:30:44
*/
public class Pro29Improve2 {
	private static final int MAXN = 1000;
	private static int[] nums = new int[MAXN];
	private static int[] consult = new int[MAXN];
	private static int[] reminder = new int[MAXN];
	private static int countNums, countCons, countRems;
	
	private static boolean isLetter(char ch){ return ch >= '0' && ch <= '9'; }
	
	public static void translate(int[] nums, int m, int n){
		countCons = 0;
		countRems = 0;
		int r;
		while(countCons < countNums){
			r = 0;
			for (int j = countCons; j < countNums; j++) {
				nums[j] += r * m;
				r = nums[j] % n;
				consult[j] = nums[j] / n;
			}
			reminder[countRems++] = r;
			while (countCons < countNums && consult[countCons] == 0){
				countCons++;
			}
			for (int i = countCons; i < countNums; i++) {
				nums[i] = consult[i];
			}
		}
		for(int i = countRems - 1; i >= 0; i--){
			System.out.print((char)(reminder[i] > 9 ? 
					reminder[i] - 10 + 'a' : reminder[i] + '0'));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int m = input.nextInt();
			int n = input.nextInt();
			String str = input.next();
			countNums = str.length();
			for(int i = 0; i < str.length(); i++){
				char ch = str.charAt(i);
				nums[i] = isLetter(ch) ? ch - '0' : ch - 'A' + 10;
			}
			translate(nums,m,n);
		}
	}
}
