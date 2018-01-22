package com.speical.first;

import java.util.Scanner;

/** 
* 求第几个素数
* 
* 打表法
* @author special
* @date 2018年1月4日 下午5:29:01
*/
public class Pro108 {
	static final int SIZE = 10000000;
	static boolean[] flag = new boolean[SIZE + 5];
	/**
	 * 打表
	 */
	public static void init(){
		flag[0] = flag[1] = true;
		for(int i = 2; i <= SIZE; i++){
			if(!flag[i]){
				for(int j = i + i; j <= SIZE; j += i){
					flag[j] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int index = 0, i = 2;
			while(index < n){
				if(!flag[i++]){
					index++;
				}
			}
			System.out.println(i - 1);
		}
	}

}
