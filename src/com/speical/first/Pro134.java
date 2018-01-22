package com.speical.first;

import java.util.Arrays;
import java.util.Scanner;

/** 
* 统计同成绩学生的人数
* @author special
* @date 2018年1月8日 上午11:29:59
*/
public class Pro134 {
	static int[] map = new int[101];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			if(n == 0) break;
			Arrays.fill(map, 0);
			while(n-- > 0){
				map[input.nextInt()]++;
			}
			System.out.println(map[input.nextInt()]);
		}
	}

}
