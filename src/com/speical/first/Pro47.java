package com.speical.first;

import java.util.Scanner;

/** 
* 吃糖果问题
* 因为一天只能吃1个或者2个
* 那么我们有n个糖果的问题转换为第一天吃1块和第一天吃2块的种树之和
* 也就是num[i] = num[i - 1] + num[i - 2]
* @author special
* @date 2017年12月28日 上午10:39:06
*/
public class Pro47 {
	public static int eatCandy(int n){
		if(n == 1) return 1;
		if(n == 2) return 2;
 		int pre = 1;
		int cur = 2;
		int temp;
		for(int i = 3; i <= n; i++){
			temp = cur;
			cur += pre;
			pre = temp;
		}
		return cur;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(input.hasNext()){
			int n = input.nextInt();
			System.out.println(eatCandy(n));
		}
	}

}
