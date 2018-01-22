package com.speical.first;

import java.util.Scanner;

/** 
* 打分规则
* @author special
* @date 2018年1月5日 下午2:08:26
*/
public class Pro118 {
	public static double getGrade(int p, int t, int g1, int g2, int g3, int gj){	
		if(Math.abs(g1 - g2) <= t){
			return (g1 + g2) / 2.0;
		}
		int diff31 = Math.abs(g3 - g1);
		int diff32 = Math.abs(g3 - g2);
		if(diff31 <= t && diff32 <= t){
			return Math.max(g1, Math.max(g2, g3));
		}else if(diff31 <= t || diff32 <= t){
			return (g3 + (diff31 < diff32 ? g1 : g2)) / 2.0;
		}else{
			return gj;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int p = input.nextInt();
			int t = input.nextInt();
			int g1 = input.nextInt();
			int g2 = input.nextInt();
			int g3 = input.nextInt();
			int gj = input.nextInt();
			System.out.format("%.1f\n", getGrade(p, t, g1, g2, g3, gj));
		}
	}

}
