package com.speical.improve;

import java.util.Scanner;

/** 
* 优化方法
* 步长大了
* 
* 思路类似求一组的最小公倍数一样
* 比如求3个数的最小公倍数，
* 先求前2个，然后再求与最后一个的
* @author special
* @date 2017年12月31日 下午4:21:22
*/
public class Pro63Improve1 {
	static final int pPeak = 23;
	static final int ePeak = 28;
	static final int iPeak = 33;
	
	public static int getDays(int p, int e, int i, int d){
		int days = d + 1;
		for(; (days - p) % pPeak != 0; days++); //先找到days后第一次p极点的位置
		for(; (days - e) % ePeak != 0; days += pPeak); //然后在保证p极点的同时找到e极点的位置
		for(; (days - i) % iPeak != 0; days += pPeak * ePeak); //最后保证p,e极点的同时找到i极点的位置
		return days - d;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int k = 0;
		while(input.hasNext()){
			int p,e,i,d;
			p = input.nextInt();
			e = input.nextInt();
			i = input.nextInt();
			d = input.nextInt();
			k++;
			if(p == -1 && e == -1 && i == -1 && d == -1){
				break;
			}
			System.out.println("Case " + k + ": the next triple peak occurs in "
					+ getDays(p, e, i, d) + " days.");
		}
	}
}
