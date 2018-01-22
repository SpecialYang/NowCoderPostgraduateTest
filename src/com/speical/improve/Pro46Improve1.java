package com.speical.improve;

import java.util.Scanner;

/** 
* 类似辗转相除的思想
* 
* 因为i，j 必然包含一个公共的父节点
* 所以我们比较其大小，令其交替除2
* @author special
* @date 2017年12月28日 上午10:29:05
*/
public class Pro46Improve1 {
	
	public static int getCommonFather(int n, int m){
		while(n != m){
			if(n > m){
				n /= 2;
			}else if(n < m){
				m /= 2;
			}
		}
		return n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			int m = input.nextInt();
			System.out.println(getCommonFather(n,m));
		}
	}

}
